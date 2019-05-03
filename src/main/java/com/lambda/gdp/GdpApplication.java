package com.lambda.gdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GdpApplication
{
    public static gdpList ourgdpList;
    public static void main(String[] args) {
        ourgdpList = new gdpList();
        SpringApplication.run(GdpApplication.class, args);
    }

}
