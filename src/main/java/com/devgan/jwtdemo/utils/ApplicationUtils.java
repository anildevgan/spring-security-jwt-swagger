package com.devgan.jwtdemo.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class ApplicationUtils {

    @Autowired
    ObjectMapper mapper;

    public <T> List<T> parseObjectList(Class<T> type, String filename) {
        JavaType javaType = mapper.getTypeFactory().constructCollectionType(List.class, type);
        try {
            InputStream inputStream =getClass().getClassLoader().getResourceAsStream(filename);
            String data = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            return mapper.readValue(data, javaType);
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
    }
}
