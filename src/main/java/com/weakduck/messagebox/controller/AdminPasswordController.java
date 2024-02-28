package com.weakduck.messagebox.controller;

import com.weakduck.messagebox.dto.ChangePasswordDTO;
import com.weakduck.messagebox.dto.CheckPasswordDTO;
import com.weakduck.messagebox.response.ApiResponse;
import com.weakduck.messagebox.service.AdminPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.FailedLoginException;

@RestController
@RequestMapping("/api/admin")
public class AdminPasswordController {
    private final AdminPasswordService adminPasswordService;

    @Autowired
    public AdminPasswordController(AdminPasswordService adminPasswordService) {
        this.adminPasswordService = adminPasswordService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> changeAdminPassword(@RequestBody ChangePasswordDTO body ) throws FailedLoginException {
        adminPasswordService.changeAdminPassword(body);
        return ResponseEntity.ok(ApiResponse.success(""));
    }

    @PostMapping("/check")
    public ResponseEntity<ApiResponse<Boolean>> checkAdminPassword(@RequestBody CheckPasswordDTO body) throws FailedLoginException {
        return ResponseEntity.ok(ApiResponse.success(adminPasswordService.isCorrectAdminPassword(body.getPassword())));
    }

}
