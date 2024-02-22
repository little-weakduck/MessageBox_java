package com.weakduck.messagebox.config;

import com.weakduck.messagebox.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFoundException(IllegalArgumentException ex, WebRequest request) {
        ApiResponse<Object> apiResponse = ApiResponse.error(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    // 处理通用异常
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleAllExceptions(Exception ex, WebRequest request) {
        ApiResponse<Object> apiResponse = ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getLocalizedMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
