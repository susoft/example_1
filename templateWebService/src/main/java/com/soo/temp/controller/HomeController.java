package com.soo.temp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/indexSession")
    public String indexSession(Model model, HttpSession session) {
		logger.info("indexSession......");
		List<String> msgs = (List<String>) session.getAttribute("MY_MESSAGES");
        if(msgs == null) {
            msgs = new ArrayList<>();
            logger.info("msgs " + msgs);
        }
        model.addAttribute("messages", msgs);
        return "indexSession";
    }

    @PostMapping("/messages")
    public String saveMessage(@RequestParam("msg") String msg, HttpServletRequest request) {
    	logger.info("saveMessage......");
    	List<String> msgs = (List<String>) request.getSession().getAttribute("MY_MESSAGES");
        if(msgs == null) {
            msgs = new ArrayList<>();
            request.getSession().setAttribute("MY_MESSAGES", msgs);
            logger.info("msgs " + msgs);
        }
        msgs.add(msg);
        return "redirect:/indexSession";
    }
}
