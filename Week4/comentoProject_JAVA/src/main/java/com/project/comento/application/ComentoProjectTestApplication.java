package com.project.comento.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.project.comento")
@MapperScan(basePackages = "com.project.comento.dao.mapper")
public class ComentoProjectTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComentoProjectTestApplication.class, args);
	}

}
