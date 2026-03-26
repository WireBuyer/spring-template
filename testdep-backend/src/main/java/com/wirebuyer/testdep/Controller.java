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
    private final MessageRepository messageRepository;

    @Value("${variable}")
    private String myVar;

    public Controller(Environment env, MessageRepository messageRepository) {
        this.env = env;
        this.messageRepository = messageRepository;
    }

    @GetMapping("/hello")
    public String sayHello() {
        String profiles = String.join(", ", env.getActiveProfiles());
        Message m = messageRepository.findFirstByOrderByIdDesc();
        String dbText = m != null ? m.getText() : "(no message)";

        return "hello world! active profiles: " + profiles + " " + myVar + " db: " + dbText;
    }
}
