package co.crisi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonMapperUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public <T> T asObject(String responseJson, Class<T> type) {
        try {
            return MAPPER.readValue(responseJson, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
