package com.example.demo.service;

import com.example.demo.entities.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.function.Consumer;

@Service
public class PageEventService {

    @Bean
    public Consumer<String> pageEventConsumer(){
        return (input) -> {
            System.out.println("***********************");
            String pageEvent = input.toString() ;
            System.out.println(decodeBase64String(pageEvent));
            System.out.println("***********************");
        };
    }

    public static String decodeBase64String(String base64String) {
        // Check if the decoded string starts and ends with double quotes
        if (base64String.startsWith("\"") && base64String.endsWith("\"")) {
            // Remove the double quotes
            base64String = base64String.substring(1, base64String.length() - 1);
        }
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);
        String decodedString = new String(decodedBytes);


        return decodedString;
    }

}
