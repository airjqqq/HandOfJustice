package com.airjqqq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Airj on 2016/9/15.
 */
@SpringBootApplication
@Controller
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    RestTemplate restTemplate(){
        RestTemplate template = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = template.getMessageConverters();
        messageConverters.add(new StringHttpMessageConverter());
        template.setMessageConverters(messageConverters);
        return template;
    }
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
