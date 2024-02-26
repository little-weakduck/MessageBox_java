package com.weakduck.messagebox.dto;

public class CreateCommentDTO {
    private String content;

    private String author;

    private String title;
    private Long parentId;

    public CreateCommentDTO() {
    }

    public CreateCommentDTO(String content, String author, String title, Long parentId) {
        this.content = content;
        this.parentId = parentId;
        this.author = author;
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public Long getParentId() {
        return parentId;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}
