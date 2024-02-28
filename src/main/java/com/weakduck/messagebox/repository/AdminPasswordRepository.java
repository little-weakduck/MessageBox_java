package com.weakduck.messagebox.repository;

import com.weakduck.messagebox.model.AdminPassword;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.security.auth.login.FailedLoginException;
import java.util.Objects;



public interface AdminPasswordRepository extends JpaRepository<AdminPassword, Long>{

    default Boolean isCorrectAdminPassword(String inputAdminPassword) throws FailedLoginException {
        final boolean result = Objects.equals(findById(1L).orElse(new AdminPassword("aeyfdigds8ifsdt86ftesyftsuefqr63")).getAdminPassword(), inputAdminPassword);

        if (!result) {
            throw new FailedLoginException("Incorrect admin password");
        }
        return true;
    }

    default void setAdminPassword(String adminPassword) {
        AdminPassword adminPasswordEntity = findById(1L).orElse(new AdminPassword(""));
        adminPasswordEntity.setAdminPassword(adminPassword);
        save(adminPasswordEntity);
    }
}