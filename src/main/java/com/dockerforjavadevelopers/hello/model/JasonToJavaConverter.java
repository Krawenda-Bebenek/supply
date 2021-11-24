package com.dockerforjavadevelopers.hello.model;


import com.dockerforjavadevelopers.hello.model.entity.ExchangeDefinitionContainer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JasonToJavaConverter {


    public static ExchangeDefinitionContainer convertingJsonsToObject(String jsonFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        try {
          return objectMapper.readValue(jsonFile, new TypeReference<ExchangeDefinitionContainer>(){});
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Parsing json to java object exception.");
        }
        return null;
    }
}