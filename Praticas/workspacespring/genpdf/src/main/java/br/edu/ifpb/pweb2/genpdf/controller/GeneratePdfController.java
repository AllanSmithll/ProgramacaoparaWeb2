package br.edu.ifpb.pweb2.genpdf.controller;

import java.io.ByteArrayOutputStream;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class GeneratePdfController {

    @RequestMapping("/genpdf")
    public ResponseEntity<byte[]> generatePdf() {

        Document document = new Document();
        ResponseEntity<byte[]> response = null;

        try {
            // Começa a criar o documento PDF usando a biblioteca iText
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, bos);
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);
            Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
            Chunk chunk = new Chunk("Título do Parágrafo", titleFont);
            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
            chapter.setNumberDepth(0);
            chapter.add(new Paragraph("Texto do parágrafo... ", paragraphFont));
            document.add(chapter);
            document.close();

            // Começa a gerar a resposta HTTP para um tipo de arquivo diferente de HTML
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            String filename = "meupdf.pdf";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            response = new ResponseEntity<>(bos.toByteArray(), headers, HttpStatus.OK);
            return response;
        } catch (DocumentException e) {
            System.out.println("Erro ao gerar PDF " + e.getMessage());
        }
        return response;
    }
}