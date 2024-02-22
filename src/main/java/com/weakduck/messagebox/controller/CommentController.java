package com.weakduck.messagebox.controller;

import com.weakduck.messagebox.dto.CreateCommentDTO;
import com.weakduck.messagebox.model.Comment;
import com.weakduck.messagebox.response.ApiResponse;
import com.weakduck.messagebox.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<Comment>>> getAllComments(Pageable pageable) {
        Page<Comment> page = commentService.findAllComments(pageable);
        return ResponseEntity.ok(ApiResponse.success(page));
    }


    @PostMapping
    public ResponseEntity<ApiResponse<String>> createComment(@RequestBody CreateCommentDTO createCommentDTO) {
        commentService.saveComment(createCommentDTO);
        return ResponseEntity.ok(ApiResponse.success(""));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
//        return commentService.findCommentById(id)
//                .map(existingComment -> {
//                    // Update the properties of the existing comment with that of the new one
//                    // For simplicity, here we just update the content
//                    existingComment.setContent(comment.getContent());
//                    existingComment.setUpdatedAt(System.currentTimeMillis());
//                    Comment updatedComment = commentService.saveComment(existingComment);
//                    return ResponseEntity.ok(updatedComment);
//                })
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        if (commentService.findCommentById(id).isPresent()) {
            commentService.deleteComment(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
