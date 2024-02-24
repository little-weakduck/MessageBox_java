package com.weakduck.messagebox.service;

import com.weakduck.messagebox.dto.CreateCommentDTO;
import com.weakduck.messagebox.dto.MyPage;
import com.weakduck.messagebox.model.Comment;
import com.weakduck.messagebox.repository.CommentRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.security.auth.login.FailedLoginException;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private  final AdminPasswordService adminPasswordService;


    @Autowired
    public CommentService(CommentRepository commentRepository,AdminPasswordService adminPasswordService ) {
        this.commentRepository = commentRepository;
        this.adminPasswordService = adminPasswordService;
    }

    public MyPage<Comment> findAllComments(int page, int size) {
        Page<Comment> resultPage = commentRepository.findAll(PageRequest.of(page - 1, size));
        List<Comment> comments = resultPage.getContent();
        comments.forEach(comment -> Hibernate.initialize(comment.getChildren());

        long total = resultPage.getTotalElements();

        return new MyPage<>(page, size, total, comments);
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

    public void deleteComment(Long id, String adminPassword) throws FailedLoginException {

        adminPasswordService.isCorrectAdminPassword(adminPassword);

        commentRepository.deleteById(id);
    }

    // Additional business logic can be added here
}
