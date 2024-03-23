package iuh.spring.user.controller;

import iuh.spring.user.entity.User;
import iuh.spring.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@GetMapping("")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
		return user;
	}

	@PostMapping("")
	public User saveUser(@RequestBody  User user){
		return userRepository.save(user);
	}

	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Long id){
		userRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User userUpdate){
		User user = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
		user.setName(userUpdate.getName());
		return userRepository.save(user);
	}
}
