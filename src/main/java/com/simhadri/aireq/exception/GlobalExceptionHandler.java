package com.simhadri.aireq.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(
            NotFoundException ex, HttpServletRequest req) {

        return buildError(ex.getMessage(), HttpStatus.NOT_FOUND, req);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequest(
            BadRequestException ex, HttpServletRequest req) {

        return buildError(ex.getMessage(), HttpStatus.BAD_REQUEST, req);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(
            MethodArgumentNotValidException ex, HttpServletRequest req) {

        return buildError("Validation failed", HttpStatus.BAD_REQUEST, req);
    }

    private ResponseEntity<ApiError> buildError(
            String msg, HttpStatus status, HttpServletRequest req) {

        ApiError error = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(msg)
                .path(req.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(error);
    }
}
