package com.weakduck.messagebox.repository;

import com.weakduck.messagebox.model.Comment;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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
    }

    Page<Comment> findAllByDeletedIsFalse(Pageable pageable);

    long countByDeletedIsFalse();
    default void deleteById(@NotNull Long id){
        Comment comment = findByIdAndDeletedIsFalse(id);
        comment.setDeleted(true);
        save(comment);
    }

}