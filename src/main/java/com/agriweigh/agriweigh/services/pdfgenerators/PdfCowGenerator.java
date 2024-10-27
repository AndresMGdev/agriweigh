package com.agriweigh.agriweigh.services.pdfgenerators;

import org.springframework.stereotype.Service;

import com.itextpdf.layout.element.Table;
import java.util.List;

import com.agriweigh.agriweigh.models.Cow;

@Service
public class PdfCowGenerator extends PdfGenerator<Cow> {

    @Override
    protected void addRowsToTable(Table table, List<Cow> cows) {
        for (Cow cow : cows) {
            table.addCell(String.valueOf(cow.getCode()));
            table.addCell(String.valueOf(cow.getAge()));
            table.addCell(String.valueOf(cow.getBodyLength()));
            table.addCell(String.valueOf(cow.getChestCircumference()));
            table.addCell(String.valueOf(cow.getEstimatedWeight()));
        }
    }
}