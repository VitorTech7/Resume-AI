package com.vitor.resumeai.dto;

public class ResumeResponse {

    private byte[] pdf;
    private String text;

    public byte[] getPdf() {
        return pdf;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
