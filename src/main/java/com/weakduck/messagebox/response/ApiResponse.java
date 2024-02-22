package com.weakduck.messagebox.response;

public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;

    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // 快速创建成功响应的静态方法
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "Success", data);
    }

    // 快速创建错误响应的静态方法
    public static <T> ApiResponse<T> error(int status, String message) {
        return new ApiResponse<>(status, message, null);
    }

    // Getter and Setter
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
