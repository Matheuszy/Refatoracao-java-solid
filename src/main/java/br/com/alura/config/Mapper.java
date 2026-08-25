package br.com.alura.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Mapper {

    private final ObjectMapper mapper = new ObjectMapper();
    public <T> T mapear(String json, Class<T> classeAlvo) {
        try {
            return mapper.readValue(json, classeAlvo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter JSON para a classe: " + classeAlvo.getName(), e);
        }
    }
}