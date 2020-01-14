package com.wxm.wmall.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.wxm.wmall.user.mapper")
public class WmallUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WmallUserServiceApplication.class, args);
	}

}
