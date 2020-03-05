package com.blove.space;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan(basePackages = "com.blove.*.mapper")
@SpringBootApplication
public class IntimateSpaceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(IntimateSpaceApplication.class, args);
    }



    @Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

}
