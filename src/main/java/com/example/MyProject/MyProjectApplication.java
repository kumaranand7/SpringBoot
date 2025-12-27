package com.example.MyProject;

import com.example.MyProject.Entity.User;
import com.example.MyProject.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner test(UserRepository repo) {
		return args -> {
			User u = new User();
			u.setName("Anand");
			u.setEmail("anand@gmail.com");

			repo.save(u);

			System.out.println("Users in DB:");
			repo.findAll().forEach(System.out::println);
		};
	}
}
