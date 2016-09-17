package com.airjqqq.account;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Airj on 2016/9/15.
 */
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountController {
    private final RestTemplate restTemplate;
    private static final String formatUrl = "http://www.battlenet.com.cn/wow/zh/character/白银之手/%s/advanced";

    @RequestMapping(value = "/bind",method = RequestMethod.PUT)
    HttpEntity bind() {
        return ResponseEntity.ok(null);
    }
    @RequestMapping(value = "/find/{name}",method = RequestMethod.GET)
    HttpEntity find(@PathVariable String name) throws URISyntaxException {
        try {
            String content = null;
            Character character = new Character();
            character.setName(name);
            URLConnection connection = null;
            try {
                connection =  new URL(String.format(formatUrl, name)).openConnection();
                Scanner scanner = new Scanner(connection.getInputStream());
                scanner.useDelimiter("\\Z");
                content = scanner.next();
                Pattern itemLevel = Pattern.compile("<span class=\"equipped\">(.*)</span>");
                Matcher m = itemLevel.matcher(content);
                if (m.find()) {
                    String s = m.group(1);
                    character.setItemLevel(s);
                }
            }catch ( Exception ex ) {
                ex.printStackTrace();
            }
//            System.out.println(content);
            return ResponseEntity.ok(character);
        } catch (HttpClientErrorException errorException){
            return ResponseEntity.notFound().build();
        }
    }
}
