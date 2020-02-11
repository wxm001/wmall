package com.wxm.wmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.wxm.wmall.cart.mapper")
public class WmallCartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WmallCartServiceApplication.class, args);
	}

}
