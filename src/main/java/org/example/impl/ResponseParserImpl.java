package org.example.impl;

import org.example.dto.AnswerCode;
import org.example.dto.Client;
import org.example.dto.ResponseDTO;
import org.example.interfaces.ResponseParser;

public class ResponseParserImpl implements ResponseParser {
    @Override
    public ResponseDTO parse(String legacyResponse) {
        Client client = new Client();
        AnswerCode answerCode = new AnswerCode();
        if (legacyResponse == null) {
            answerCode.setStatus("ERROR");
            answerCode.setMessage("Response is null");
            return new ResponseDTO(client, answerCode);
        } else {
            client.setId(legacyResponse.substring(0, 4));
            client.setNombre(legacyResponse.substring(4, 14).trim());
            // Check if the substring is a valid integer
            String edadStr = legacyResponse.substring(14, 16);
            if (isNumeric(edadStr)) {
                client.setEdad(Integer.parseInt(edadStr));
            } else {
                answerCode.setStatus("ERROR");
                answerCode.setMessage("Invalid age format");
                return new ResponseDTO(client, answerCode);
            }
            client.setEstado(legacyResponse.substring(16, 17));
            answerCode.setStatus("OK");
            answerCode.setMessage("Client Selected");
            return new ResponseDTO(client, answerCode);
        }
    }

    private boolean isNumeric(String valor) {
        return valor != null && valor.matches("\\d+");
    }
}