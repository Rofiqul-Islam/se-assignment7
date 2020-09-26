package com.rofiq.SE.Assignment7;

import com.rofiq.SE.Assignment7.model.State;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment7Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment7Application.class, args);
		System.out.println(State.Pending);
	}

}
