package com.devgan.jwtdemo.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class ApplicationUtils {

    @Autowired
    ObjectMapper mapper;

    public <T> List<T> parseObjectList(Class<T> type, String filename) {
        JavaType javaType = mapper.getTypeFactory().constructCollectionType(List.class, type);
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(filename).getFile());
            return mapper.readValue(file, javaType);
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
    }
}
