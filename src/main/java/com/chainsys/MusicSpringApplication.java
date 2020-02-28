package com.chainsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@ServletComponentScan("com.chainsys")
public class MusicSpringApplication  extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MusicSpringApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MusicSpringApplication.class, args);
	}

}
