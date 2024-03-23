package iuh.spring.product;

import iuh.spring.product.entity.Product;
import iuh.spring.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductApplication {
	@Autowired
	private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
//	@Bean
//	CommandLineRunner commandLineRunner(){
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				for (long i = 1; i<=5;i++){
//					productRepository.save(new Product("Product "+ i));
//				}
//			}
//		};
//	}
}
