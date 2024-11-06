package com.agriweigh.agriweigh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agriweigh.agriweigh.models.Pig;
import com.agriweigh.agriweigh.services.PigService;
import com.agriweigh.agriweigh.services.pdfgenerators.PdfPigGenerator;
import com.itextpdf.io.exceptions.IOException;
import com.itextpdf.io.source.ByteArrayOutputStream;

import java.util.List;

@Controller
@RequestMapping("/pigs")
public class PigController {

    @Autowired
    private PigService pigService;

    @Autowired
    private PdfPigGenerator pdfPigGenerator;

    @GetMapping("/list")
    public String listPig(Model model) {
        model.addAttribute("pigs", pigService.findAll());
        return "pigs/list";
    }

    @GetMapping("/new")
    public String showFormRegister(Model model) {
        model.addAttribute("pig", new Pig());
        return "pigs/form";
    }

    @PostMapping
    public String savePig(@ModelAttribute Pig pig) {
        pigService.save(pig);
        return "redirect:/pigs/list";
    }
    
    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("pig", pigService.findById(id).orElse(new Pig()));
        return "pigs/form";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteHorse(@PathVariable("id") Long id) {
        pigService.delete(id);
        return "redirect:/pigs/list";
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadPigPdf() throws IOException {
        List<Pig> pigs = pigService.findAll();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        pdfPigGenerator.generatePdf(pigs, outputStream);

        byte[] pdfBytes = outputStream.toByteArray();

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"pigs.pdf\"")
                .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}
