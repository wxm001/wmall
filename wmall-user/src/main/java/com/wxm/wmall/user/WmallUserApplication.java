package com.wxm.wmall.user;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.wxm.wmall.user.mapper")
public class WmallUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(WmallUserApplication.class, args);
	}
}
