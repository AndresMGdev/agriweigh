package com.agriweigh.agriweigh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agriweigh.agriweigh.models.Horse;
import com.agriweigh.agriweigh.services.HorseService;
import com.agriweigh.agriweigh.services.pdfgenerators.PdfHorseGenerator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/horses")
public class HorseController {

    @Autowired
    private HorseService horseService;

    @Autowired
    private PdfHorseGenerator pdfHorseGenerator;

    @GetMapping("/list")
    public String listCows(Model model) {
        model.addAttribute("horses", horseService.findAll());
        return "horses/list";
    }

    @GetMapping("/new")
    public String showFormRegister(Model model) {
        model.addAttribute("horse", new Horse());
        return "horses/form";
    }

    @PostMapping
    public String saveHorse(@ModelAttribute Horse horse) {
        horseService.save(horse);
        return "redirect:/horses/list";
    }
    
    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("horse", horseService.findById(id).orElse(new Horse()));
        return "horses/form";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteHorse(@PathVariable Long id) {
        horseService.delete(id);
        return "redirect:/horses/list";
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadCowsPdf() throws IOException {
        List<Horse> horses = horseService.findAll();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        pdfHorseGenerator.generatePdf(horses, outputStream);

        byte[] pdfBytes = outputStream.toByteArray();

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"horses.pdf\"")
                .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}
