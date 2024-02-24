package com.weakduck.messagebox.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AdminPassword {

    @Id
    private Long id = 1L;

    private String adminPassword;

    public AdminPassword() {
    }

    public AdminPassword(String adminPassword) {
        this.id = 1L;
        this.adminPassword = adminPassword;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
