package com.weakduck.messagebox.dto;

import java.util.Objects;

public class ChangePasswordDTO {
    private String oldPassword;
    private String newPassword;
    private  String check;


    public ChangePasswordDTO() {}

    public ChangePasswordDTO(String oldPassword, String newPassword, String check) {
        this.check = check;
        this.newPassword = newPassword;
        this.oldPassword = oldPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public Boolean isCheck() {
        return Objects.equals(newPassword, check);
    }

}
