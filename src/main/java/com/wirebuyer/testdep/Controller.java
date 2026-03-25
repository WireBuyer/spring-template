package com.wirebuyer.testdep;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class Controller {
    private final Environment env;
    @Value("${variable}")
    private String myVar;

    public Controller(Environment env) {
        this.env = env;
    }

    @GetMapping("/hello")
    public String sayHello() {
        String profiles = String.join(", ", env.getActiveProfiles());

        return "hello world! active profiles: " + profiles + " " + myVar;
    }
}
