package com.example.springmvc.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {
    List<String> StringList = new ArrayList<>();
    @PostConstruct
    public void text(){
        StringList = new ArrayList<>();
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }


    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
    @PostMapping("/contact/post")
    public String contactPost(@RequestParam ("test" )String test){
        System.out.println("test = " + test);
        StringList.add(test);
        return "redirect:/index";
    }
    @GetMapping("/")
    public String contactList(Model model){
      List<String> StringList = new ArrayList<>();
        model.addAttribute("StringList",StringList);
        return "index";
    }
}
