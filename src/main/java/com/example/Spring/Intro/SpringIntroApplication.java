package com.example.Spring.Intro;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
@Data
class Content{
	String firstName;
	String lastName;
}
@SpringBootApplication
@RestController
@RequestMapping("/hello")
public class SpringIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntroApplication.class, args);
	}

	@GetMapping
	public String sayHello(){
		return "Hello from BridgeLabz!";
	}

	@GetMapping("/query")
	public String sayHelloWithQuery(@RequestParam String name){
		return "Hello " + name + " from BridgeLabz!";
	}

	@GetMapping("/param/{name}")
	public String sayHelloWithParam(@PathVariable String name){
		return "Hello " + name + " from BridgeLabz!";
	}

	@PostMapping("/post")
	public String sayHelloWithInput(@RequestBody Content content){
		return "Hello " + content.getFirstName() + " " + content.getLastName() + " from BridgeLabz!";
	}

	@PutMapping("put/{firstName}")
	public String sayHelloWithBoth(@PathVariable String firstName, @RequestParam String lastName){
		return "Hello " + firstName + lastName + " from BridgeLabz!";
	}
}
