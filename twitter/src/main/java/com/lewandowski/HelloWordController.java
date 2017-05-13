package com.lewandowski;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    @RequestMapping("/")
    public String helloWord() {
        return "Hello Word";
    }
}
