package org.example.javasample.impl;

import org.example.dto.ResponseDTO;
import org.example.impl.ResponseParserImpl;
import org.example.interfaces.ResponseParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseParserImplTest {

    private final ResponseParser parser = new ResponseParserImpl();

    @Test
    void testParseValidResponse() {
        // This string is a mock of the response from the legacy system
        String testResponse = "1234Juan Perez28A";

        ResponseDTO dto = parser.parse(testResponse);

        assertNotNull(dto);
        assertEquals("1234", dto.getClient().getId());
        assertEquals("Juan Perez", dto.getClient().getNombre());
        assertEquals(28, dto.getClient().getEdad());
        assertEquals("A", dto.getClient().getEstado());
        assertEquals("OK", dto.getAnswerCode().getStatus());
        assertEquals("Client Selected", dto.getAnswerCode().getMessage());
    }

    @Test
    void testParseWithTrimmedName() {
        // This string is a mock of the response from the legacy system
        String fakeResponse = "5678Maria     30B"; // Extra spaces in name

        ResponseDTO dto = parser.parse(fakeResponse);
        assertEquals("Maria", dto.getClient().getNombre());
    }

    @Test
    void testParseNullResponse() {
        String nullResponse = null;

        ResponseDTO dto = parser.parse(nullResponse);

        assertNotNull(dto);
        assertEquals("ERROR", dto.getAnswerCode().getStatus());
        assertEquals("Response is null", dto.getAnswerCode().getMessage());
    }

    @Test
    void testParseInvalidAgeFormat() {
        String invalidAgeResponse = "1234Juan PerezABCD"; // Invalid age format

        ResponseDTO dto = parser.parse(invalidAgeResponse);

        assertNotNull(dto);
        assertEquals("ERROR", dto.getAnswerCode().getStatus());
        assertEquals("Invalid age format", dto.getAnswerCode().getMessage());
    }
}
