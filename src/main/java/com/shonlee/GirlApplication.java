package com.shonlee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 该 @SpringBootApplication 注解等价于以默认属性使用 @Configuration ，
 * @EnableAutoConfiguration 和 @ComponentScan 。
 */

@SpringBootApplication
// @EnableScheduling
// @EnableScheduling 启用定时任务的配置
public class GirlApplication {
	public static void main(String[] args) {
		SpringApplication.run(GirlApplication.class, args);
	}
}
