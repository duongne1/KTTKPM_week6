package iuh.spring.user;

import iuh.spring.user.entity.User;
import iuh.spring.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserApplication {
	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(){
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				for (long i = 1; i<5;i++){
//					userRepository.save(new User("User "+ i));
//				}
//			}
//		};
//	}
}
