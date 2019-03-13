package com.soo.temp.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soo.temp.vo.Greeting;

@Controller
public class HelloWorldController {
	Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

	@Value("${spring.application.name}")
    String appName;

	@GetMapping("/")
    public String home(Model model) {
		logger.info("home......");
    	
    	model.addAttribute("appName", appName);
        return "home";
    }
	
	@GetMapping("/index")
    public String index(Model model) {
		logger.info("index......");
        return "index";
    }
	
    @GetMapping("/hello-world")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
