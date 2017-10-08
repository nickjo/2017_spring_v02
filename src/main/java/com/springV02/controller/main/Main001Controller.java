package com.springV02.controller.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main001Controller {
	
	@RequestMapping(value = "mainPage.do")
    public String mainPage(){
        return "main/mainPage";
    }
}
