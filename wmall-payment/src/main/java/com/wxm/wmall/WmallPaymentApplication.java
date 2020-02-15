package com.wxm.wmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.wxm.wmall.payment.mapper")
public class WmallPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(WmallPaymentApplication.class, args);
	}

}
