package com.weakduck.messagebox.dto;

public class CreateCommentDTO {
    private String content;
    private Long parentId;

    public CreateCommentDTO() {
    }

    public CreateCommentDTO(String content, Long parentId) {
        this.content = content;
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public Long getParentId() {
        return parentId;
    }
}
