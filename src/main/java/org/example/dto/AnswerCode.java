package org.example.dto;

public class AnswerCode {
    private String status;
    private String message;

    // Constructor
    public AnswerCode(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public AnswerCode() {
        // Default constructor
    }

    // Getters and Setters
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
