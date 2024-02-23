package com.weakduck.messagebox.repository;

import com.weakduck.messagebox.model.AdminPassword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Objects;

public interface AdminPasswordRepository extends JpaRepository<AdminPassword, Long>{
    default Boolean isCorrectAdminPassword(String inputAdminPassword) {
        return Objects.equals(findById(1L).orElse(new AdminPassword("")).getAdminPassword(), inputAdminPassword);
    }

    default void setAdminPassword(String adminPassword) {
        AdminPassword adminPasswordEntity = findById(1L).orElse(new AdminPassword(""));
        adminPasswordEntity.setAdminPassword(adminPassword);
        save(adminPasswordEntity);
    }
}