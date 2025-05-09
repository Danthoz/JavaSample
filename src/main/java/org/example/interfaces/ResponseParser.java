package org.example.interfaces;
import org.example.dto.ResponseDTO;

public interface ResponseParser {
    ResponseDTO parse(String legacyResponse);
}
