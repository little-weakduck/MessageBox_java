package com.weakduck.messagebox.dto;

public class DeleteCommentDTO {
    private String password;

    public DeleteCommentDTO() {
    }

    public DeleteCommentDTO(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
