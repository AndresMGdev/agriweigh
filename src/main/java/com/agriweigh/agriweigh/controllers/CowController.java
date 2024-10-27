package com.agriweigh.agriweigh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agriweigh.agriweigh.models.Cow;
import com.agriweigh.agriweigh.services.CowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
@RequestMapping("/cows")
public class CowController {

    @Autowired
    private CowService cowService;

    @GetMapping("/list")
    public String listCows(Model model) {
        model.addAttribute("cows", cowService.findAll());
        return "cows/list";
    }

    @GetMapping("/new")
    public String showFormRegister(Model model) {
        model.addAttribute("cow", new Cow());
        return "cows/form";
    }

    @PostMapping
    public String saveCow(@ModelAttribute Cow cow) {
        cowService.save(cow);
        return "redirect:/cows/list";
    }
    
    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cow", cowService.findById(id).orElse(new Cow()));
        return "cows/form";
    }
    
    @GetMapping("/delete/{id}")
    public String getMethodName(@PathVariable Long id) {
        cowService.delete(id);
        return "redirect:/cows/list";
    }
}
