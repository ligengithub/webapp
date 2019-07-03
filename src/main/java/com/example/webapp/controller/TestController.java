package com.example.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ligen
 * @title: TestController
 * @projectName webapp
 * @description:
 * @date 2019/7/310:53
 */
@RestController
public class TestController {

    @GetMapping("/hello/{data}")
    public String hello(@PathVariable String data) {
        return data;
    }

}
