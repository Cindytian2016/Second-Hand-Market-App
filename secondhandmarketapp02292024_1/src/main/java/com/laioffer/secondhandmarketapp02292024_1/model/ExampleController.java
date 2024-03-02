package com.laioffer.secondhandmarketapp02292024_1.model;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/example")
    public ResponseEntity<String> getExample() {
        // Here we're just returning a simple string response,
        // but this could be any type of object.
        String body = "Hello, this is an example response!";

        // Create and return the ResponseEntity with the body, headers, and status code
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/exampleWithHeaders")
    public ResponseEntity<String> getExampleWithHeaders() {
        String body = "This response includes custom headers!";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "value");

        // Create and return the ResponseEntity with the body, custom headers, and status code
        return new ResponseEntity<>(body, headers, HttpStatus.OK);
    }
}

