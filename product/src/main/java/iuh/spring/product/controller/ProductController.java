package iuh.spring.product.controller;

import iuh.spring.product.entity.Product;
import iuh.spring.product.repository.ProductRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	private Jedis jedis = new Jedis();
	RestTemplate restTemplate = new RestTemplate();
	@GetMapping()
	@Cacheable(value = "product")
	public List<Product> getListProducts(){
		return productRepository.findAll();
	}

	@PostMapping()
	public Product saveProduct(@RequestBody Product product){
		return productRepository.save(product);
	}

	@GetMapping("/{id}")
	@Cacheable(value = "product", key = "#id")
	public Product findProductById(@PathVariable(value = "id") Long id){
		String key = String.valueOf(id);
		System.out.println(key);
		if (jedis.exists(key)) {
			Product productCash = new Product();
			productCash.setId(id);

//			// Lấy từ Redis dưới dạng hash
			String productName = jedis.get(key);
			// Set các thuộc tính cho đối tượng Student từ giá trị lấy từ Redis
			productCash.setName(productName);
			return productCash;
		} else {
			Product product = productRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Student_id " + id + " not found"));

			// Lưu từng trường và giá trị vào Redis dưới dạng hash
			jedis.set(key, product.getName());

			System.out.println("Saved in cache");
			return product;
		}
	}

	@DeleteMapping("/{id}")
	@CacheEvict(value = "product")
    public void deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
    }
}
