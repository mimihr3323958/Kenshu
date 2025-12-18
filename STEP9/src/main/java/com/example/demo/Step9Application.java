package com.example.demo;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.demo.repository")
@SpringBootApplication
public class Step9Application {

	public static void main(String[] args) {
		SpringApplication.run(Step9Application.class, args);
	}

}
