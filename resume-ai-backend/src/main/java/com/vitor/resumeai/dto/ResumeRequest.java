package com.vitor.resumeai.dto;

import java.util.List;

public class ResumeRequest {

    private String fullName;
    private String email;
    private String phone;
    private String summary;
    private List<Experience> experiences;
    private List<String> skills;
    private List<Education> education;

    public static class Experience {
        private String title;
        private String company;
    }

    public static class Education {
        private String degree;
    }
}

