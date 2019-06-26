package com.bigguy.movie.moviebox;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@MapperScan("com.bigguy.movie.moviebox.mapper")
@SpringBootApplication
public class MovieBoxApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieBoxApplication.class, args);
    }

}

