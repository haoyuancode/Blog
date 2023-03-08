package com.mason;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 22102
 * @version 1.0
 * @description: TODO
 * @date 2023/3/8 20:31
 */
@SpringBootApplication
//@MapperScan("com.mason.mapper")
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class,args);
    }
}