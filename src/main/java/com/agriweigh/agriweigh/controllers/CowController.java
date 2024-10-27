package com.agriweigh.agriweigh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agriweigh.agriweigh.models.Cow;
import com.agriweigh.agriweigh.services.CowService;
import com.agriweigh.agriweigh.services.pdfgenerators.PdfCowGenerator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/cows")
public class CowController {

    @Autowired
    private CowService cowService;

    @Autowired
    private PdfCowGenerator pdfCowGenerator;

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
    public String deleteCow(@PathVariable Long id) {
        cowService.delete(id);
        return "redirect:/cows/list";
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadCowsPdf() throws IOException {
        List<Cow> cows = cowService.findAll(); 
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        pdfCowGenerator.generatePdf(cows, outputStream);

        byte[] pdfBytes = outputStream.toByteArray();

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"cows.pdf\"")
                .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}
