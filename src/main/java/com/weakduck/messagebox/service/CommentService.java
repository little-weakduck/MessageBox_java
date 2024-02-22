package com.weakduck.messagebox.service;

import com.weakduck.messagebox.dto.CreateCommentDTO;
import com.weakduck.messagebox.model.Comment;
import com.weakduck.messagebox.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Page<Comment> findAllComments(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    public Optional<Comment> findCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public void saveComment(CreateCommentDTO createCommentDTO) {
        String content = createCommentDTO.getContent();
        Long parentId = createCommentDTO.getParentId();
        Comment parent = parentId != null ? commentRepository.findByIdAndDeletedIsFalse(parentId) : null;
        Comment newComment = new Comment(content, parent);
        commentRepository.save(newComment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    // Additional business logic can be added here
}
