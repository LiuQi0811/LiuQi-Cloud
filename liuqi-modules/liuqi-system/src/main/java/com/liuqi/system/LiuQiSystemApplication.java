package com.liuqi.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.liuqi.system.mapper") //mapper 扫描
public class LiuQiSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiuQiSystemApplication.class, args);
    }
}
