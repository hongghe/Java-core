package com.hongghe.basicjava.controller;

import com.hongghe.basicjava.annonation.UserAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("hello")
    @UserAccess(desc = "hello, world")
    public Object hello() {
        return "Hello, world.";
    }
}