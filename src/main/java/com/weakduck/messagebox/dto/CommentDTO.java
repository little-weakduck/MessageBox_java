package com.weakduck.messagebox.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.weakduck.messagebox.model.Comment;

public class CommentDTO {
    private Long id;
    private String content;
    private String author;
    private String title;
    private Long updatedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CommentDTO parent;

    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.author = comment.getAuthor();
        this.title = comment.getTitle();
        this.updatedAt = comment.getUpdatedAt();
        if (comment.getParent() != null) {

            this.parent = new CommentDTO(comment.getParent().getId(), comment.getParent().getContent(),comment.getParent().getTitle(),comment.getParent().getAuthor(), comment.getParent().getUpdatedAt());
        }
    }

    public CommentDTO(Long id, String content,String title,String author, Long updatedAt) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.author = author;
        this.updatedAt = updatedAt;
    }

    public CommentDTO() {
    }

    public Long getId() {
        return id;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public String getContent() {
        return content;
    }

    public CommentDTO getParent() {
        return parent;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
