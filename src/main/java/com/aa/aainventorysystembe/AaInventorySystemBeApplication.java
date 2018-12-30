package com.aa.aainventorysystembe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.file.Paths;

@SpringBootApplication
public class AaInventorySystemBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AaInventorySystemBeApplication.class, args);
	}

}
