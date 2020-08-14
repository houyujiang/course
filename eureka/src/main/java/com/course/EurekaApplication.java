package com.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@SpringBootApplication
@EnableEurekaServer
@ComponentScan({"com.*"})
public class EurekaApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(EurekaApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(EurekaApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOGGER.info("Eureka 启动成功！");
        LOGGER.info("Eureka地址：\thttp://127.0.0.1:{}",env.getProperty("server.port"));
        SpringApplication.run(EurekaApplication.class, args);
    }

}
