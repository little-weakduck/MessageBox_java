package com.weakduck.messagebox.repository;

import com.weakduck.messagebox.model.Comment;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    default Comment findByIdAndDeletedIsFalse(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id is null");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("Id is not positive");
        }
        Comment comment =  findById(id).orElse(null);
        if (comment == null || comment.getDeleted()) {
            throw new IllegalArgumentException("Comment not found");
        }
        return  comment;
    };

    default void deleteById(@NotNull Long id){
        Comment comment = findByIdAndDeletedIsFalse(id);
        comment.setDeleted(true);
        save(comment);
    }

}