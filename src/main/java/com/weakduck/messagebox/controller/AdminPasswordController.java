package com.weakduck.messagebox.controller;

import com.weakduck.messagebox.dto.ChangePasswordDTO;
import com.weakduck.messagebox.model.AdminPassword;
import com.weakduck.messagebox.response.ApiResponse;
import com.weakduck.messagebox.service.AdminPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminPasswordController {
    private final AdminPasswordService adminPasswordService;

    @Autowired
    public AdminPasswordController(AdminPasswordService adminPasswordService) {
        this.adminPasswordService = adminPasswordService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> changeAdminPassword(@RequestBody ChangePasswordDTO body ) {
        adminPasswordService.changeAdminPassword(body);
        return ResponseEntity.ok(ApiResponse.success(""));
    }

}
