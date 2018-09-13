package com.frederickwordie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frederickwordie.service.LinkService;

@Controller
public class IndexController {

	@Autowired
	LinkService linkservice;
	
	@RequestMapping(value={"/", "/index"})
    String index(Model model){
		model.addAttribute("linklist", linkservice.getAllLinks());
        return "index";
    }
}
