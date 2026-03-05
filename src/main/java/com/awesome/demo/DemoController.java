package com.awesome.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Jenkins!";
    }

    @GetMapping("/bug")
    public String bug() {
        int value = 200/0;
        return "Bug";
    }

}
