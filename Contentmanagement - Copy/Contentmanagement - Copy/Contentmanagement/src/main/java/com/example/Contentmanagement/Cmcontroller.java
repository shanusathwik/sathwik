package com.example.Contentmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Cmcontroller {
    @Autowired
    private Cmservice service;

    @RequestMapping("/")
    public String home(Model model){
        List<Content> contentlist=service.listAll();
        model.addAttribute("contentlist",contentlist);
        return "index";
    }
    @RequestMapping("/new")
    public String createe(Model model){
        Content content=new Content();
        model.addAttribute("content",content);
        return "create";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saave(@ModelAttribute("content") Content content){
        service.save(content);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView editt(@PathVariable(name = "id") long id){
        ModelAndView mav= new ModelAndView("edit" );
        Content content=service.get(id);
        mav.addObject("content",content);
        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deletee(@PathVariable(name = "id")long id){
        service.delete(id);
        return "redirect:/";
    }
}

