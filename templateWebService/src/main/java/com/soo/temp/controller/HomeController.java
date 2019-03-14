package com.soo.temp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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

	@GetMapping("/indexMybatis")
    public String indexMybatis(Model model) {
		logger.info("indexMybatis......");
        return "indexMybatis";
    }
}
