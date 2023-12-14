package com.kdg.refactoring.kdgservice;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 86136
 */
@SpringBootApplication
@MapperScan("com.kdg.refactoring.kdgservice.travel.mapper")
@ComponentScan(basePackages = {"com.kdg"})
public class KdgServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KdgServiceApplication.class, args);
    }

}
