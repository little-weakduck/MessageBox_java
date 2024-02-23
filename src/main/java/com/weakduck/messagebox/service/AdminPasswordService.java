package com.weakduck.messagebox.service;

import com.weakduck.messagebox.dto.ChangePasswordDTO;
import com.weakduck.messagebox.repository.AdminPasswordRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminPasswordService {
    private final AdminPasswordRepository adminPasswordRepository;

    public AdminPasswordService(AdminPasswordRepository adminPasswordRepository) {
        this.adminPasswordRepository = adminPasswordRepository;
    }

    public void changeAdminPassword(ChangePasswordDTO changePasswordDTO) {
        if (adminPasswordRepository.isCorrectAdminPassword(changePasswordDTO.getOldPassword())){
            if(!changePasswordDTO.isCheck()) {
                throw new IllegalArgumentException("password check error");
            }
            adminPasswordRepository.setAdminPassword(changePasswordDTO.getNewPassword());
        } else {
            throw new IllegalArgumentException("Incorrect admin password");
        }
    }

    public boolean isCorrectAdminPassword(String adminPassword) {
        return adminPasswordRepository.isCorrectAdminPassword(adminPassword);
    }
}
