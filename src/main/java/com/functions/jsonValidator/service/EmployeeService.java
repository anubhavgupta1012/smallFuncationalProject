package com.functions.jsonValidator.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.functions.jsonValidator.model.Employee;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final JsonSchema jsonSchema;

    @SneakyThrows
    public boolean testValidEmployee(Employee employee) {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(employee);
        JsonNode jsonNode = mapper.readTree(json);
        Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);
        return errors.isEmpty();
    }
}
