package com.example.springmvc.demo.controllers;

import com.example.springmvc.demo.dto.ContactDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {
    List<ContactDto> contactDtoList;
    List<String> aboutList;
    @PostConstruct
    public void text(){
        contactDtoList=new ArrayList<>();
        aboutList = new ArrayList<>();
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/aboutIndex")
    public String aboutIndex(){
        return "aboutIndex";
    }

    @GetMapping("/contact")
    public String contact(Model model){
        ContactDto dtoField = new ContactDto();
        model.addAttribute("dtoField",dtoField);
        return "contact";
    }
    @GetMapping("/about")
    public String about(Model model){
        return "about";
    }
    @GetMapping("/")
    public String contactList(Model model){
        model.addAttribute("contactDtoList",contactDtoList);
        return "index";
    }

    @GetMapping("/aboutIndex/addingList")
    public String aboutGet(Model model){
        model.addAttribute("aboutList",aboutList);
        return "aboutIndex";
    }

    @PostMapping("/about/post")
    public String aboutPost(String input , String email){
        aboutList.add(input);
        aboutList.add(email);
        System.out.println(input);
        return "redirect:/aboutIndex/addingList";
    }
    @PostMapping("/contact")
    public String contactPost( ContactDto dto){
        contactDtoList.add(dto);
        return "redirect:/";
    }

}
