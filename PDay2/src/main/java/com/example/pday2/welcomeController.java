package com.example.pday2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcomeController {
    @GetMapping("/name")
    public String name(){
        return "My name is Abeer";
    }
    @GetMapping("/age")
    public String age(){
        return "عمري 24";
    }
    @GetMapping("/check")
    public String check(){
        return "كل شيء على ما يرام";
    }
    @GetMapping("/health")
    public String health(){
        return "صحة الخادم قيد التشغيل";
    }
}
