package com.agriweigh.agriweigh.services.pdfgenerators;

import org.springframework.stereotype.Service;

import com.itextpdf.layout.element.Table;

import com.agriweigh.agriweigh.models.Horse;

import java.util.List;

@Service
public class PdfHorseGenerator extends PdfGenerator<Horse> {

    @Override
    protected void addRowsToTable(Table table, List<Horse> horses) {
        for (Horse horse : horses) {
            table.addCell(String.valueOf(horse.getCode()));
            table.addCell(String.valueOf(horse.getAge()));
            table.addCell(String.valueOf(horse.getBodyLength()));
            table.addCell(String.valueOf(horse.getChestCircumference()));
            table.addCell(String.valueOf(horse.getEstimatedWeight()));
        }
    }
}
