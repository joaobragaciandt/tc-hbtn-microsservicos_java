package com.example.user.exception;

import java.io.Serializable;

public class UserErrorResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    int status;
    String message;

    public UserErrorResponse() {
    }

    public UserErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

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
}
