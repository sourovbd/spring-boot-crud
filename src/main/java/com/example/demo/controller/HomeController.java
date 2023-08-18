package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @GetMapping("/user")
    public User user() {
        User user = new User();
        user.setId("1");
        user.setName("Sourov");
        user.setEmailId("atiqsourov.sust@gmail.com");
        return user;
    }
    /**
     * @PathVariable: when variable is mandatory
     */
    @GetMapping("/user/{id}/{id2}")
    public String getPathVariable(@PathVariable String id,
                                  @PathVariable("id2") String name) {
        return "The path variable id: " + id + " & name: " + name;
    }

    /**
     * @RequestParam: when variable is optional.
     */
    @GetMapping("/user/request-param")
    public String getRequestParam(@RequestParam String name,
                                  @RequestParam(name = "email", required = false, defaultValue = "") String emailId) {
        return "The name is: " + name + " & email: " + emailId;
    }
}
