package com.vitor.resumeai.service;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.vitor.resumeai.client.OpenAiClient;
import com.vitor.resumeai.dto.ResumeRequest;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class ResumeService {

    private final OpenAiClient openAiClient;

    public ResumeService(OpenAiClient openAiClient) {
        this.openAiClient = openAiClient;
    }

    public byte[] generatePdfFromRequest(ResumeRequest request) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("Nome: ").append(request.getFullName()).append("\n");
        builder.append("Resumo: ").append(openAiClient.generateText(request.getSummary())).append("\n");
        builder.append("Experiência: ").append(openAiClient.generateText(request.getExperience())).append("\n");
        builder.append("Habilidades: ").append(openAiClient.generateText(request.getSkills())).append("\n");
        builder.append("Educação: ").append(openAiClient.generateText(request.getEducation())).append("\n");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        document.add(new Paragraph(builder.toString()));
        document.close();

        return out.toByteArray();
    }
}
