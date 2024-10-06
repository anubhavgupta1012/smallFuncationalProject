package com.functions.jsonValidator.config;

import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class AppConfiguration {
    private static final String SCHEMA_VALIDATION_FILE = "validation.json";

    @Bean
    public JsonSchema jsonSchema() {
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909);
        InputStream schemaStream = inputStreamFromClasspath(SCHEMA_VALIDATION_FILE);
        JsonSchema schema = schemaFactory.getSchema(schemaStream);
        return schema;
    }

    private static InputStream inputStreamFromClasspath(String path) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }
}