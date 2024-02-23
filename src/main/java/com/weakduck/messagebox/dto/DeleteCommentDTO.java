package com.weakduck.messagebox.dto;

public class DeleteCommentDTO {
    private String adminPassword;

    public DeleteCommentDTO() {
    }

    public DeleteCommentDTO(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminPassword() {
        return adminPassword;
    }
}
