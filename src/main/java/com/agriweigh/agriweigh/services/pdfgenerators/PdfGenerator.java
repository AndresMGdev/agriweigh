package com.agriweigh.agriweigh.services.pdfgenerators;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;

import java.io.OutputStream;
import java.util.List;

public abstract class PdfGenerator<T> {

    protected abstract void addRowsToTable(Table table, List<T> animals);

    // Método genérico para crear el PDF
    public void generatePdf(List<T> animals, OutputStream outputStream) {
        PdfWriter pdfWriter = new PdfWriter(outputStream);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        // Crear tabla con los encabezados comunes
        Table table = new Table(new float[]{1, 1, 1, 1, 1});
        addTableHeaders(table);

        // Agregar las filas específicas del animal
        addRowsToTable(table, animals);

        document.add(table);
        document.close();
    }

    // Método para agregar encabezados a la tabla
    private void addTableHeaders(Table table) {
        table.addHeaderCell("Código");
        table.addHeaderCell("Edad");
        table.addHeaderCell("Longitud (cm)");
        table.addHeaderCell("Circunferencia (cm)");
        table.addHeaderCell("Peso Estimado (kg)");
    }
}
