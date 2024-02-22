package com.weakduck.messagebox.dto;

public class DeleteCommentDTO {
    private Long id;
    private String adminPassword;

    public DeleteCommentDTO() {
    }

    public DeleteCommentDTO(Long id, String adminPassword) {
        this.id = id;
        this.adminPassword = adminPassword;
    }

    public Long getId() {
        return id;
    }

    public String getAdminPassword() {
        return adminPassword;
    }
}
