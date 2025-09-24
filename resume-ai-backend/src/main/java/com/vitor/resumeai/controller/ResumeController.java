package com.vitor.resumeai.controller;

import com.vitor.resumeai.service.ResumeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/test")
    public String test() {
        return "Backend rodando 🚀";
    }

    @PostMapping("/generate-pdf")
    public ResponseEntity<byte[]> generatePdf(@RequestBody Object request) throws IOException {
        byte[] pdf = resumeService.generatePdfStub();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=curriculo.pdf");
        return ResponseEntity.ok().headers(headers).body(pdf);
    }
}
