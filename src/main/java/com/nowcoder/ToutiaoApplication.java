package com.nowcoder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.nowcoder.dao")
public class ToutiaoApplication extends SpringBootServletInitializer {
/*    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ToutiaoApplication.class);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(ToutiaoApplication.class, args);
    }
}
