package com.agriweigh.agriweigh.services.pdfgenerators;

import org.springframework.stereotype.Service;

import com.agriweigh.agriweigh.models.Pig;
import com.itextpdf.layout.element.Table;

import java.util.List;

@Service
public class PdfPigGenerator extends PdfGenerator<Pig> {

    @Override
    protected void addRowsToTable(Table table, List<Pig> pigs) {
        for (Pig pig : pigs) {
            table.addCell(String.valueOf(pig.getCode()));
            table.addCell(String.valueOf(pig.getAge()));
            table.addCell(String.valueOf(pig.getBodyLength()));
            table.addCell(String.valueOf(pig.getChestCircumference()));
            table.addCell(String.valueOf(pig.getEstimatedWeight()));
        }
    }
}
