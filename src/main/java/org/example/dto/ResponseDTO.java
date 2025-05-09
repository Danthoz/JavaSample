package org.example.dto;
// DTO with library output structure
public class ResponseDTO {
    private Client client;
    private AnswerCode answerCode;

    // Constructor

    public ResponseDTO(Client client, AnswerCode answerCode) {
        this.client = client;
        this.answerCode = answerCode;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public AnswerCode getAnswerCode() {
        return answerCode;
    }

    public void setAnswerCode(AnswerCode answerCode) {
        this.answerCode = answerCode;
    }
}





