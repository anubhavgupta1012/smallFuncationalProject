package com.functions.jsonValidator.controller;

import com.functions.jsonValidator.model.Employee;
import com.functions.jsonValidator.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class JsonValidatorController {

    private final EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity testValidEmployee(@RequestBody Employee employee) {
        boolean isValid = employeeService.testValidEmployee(employee);
        return ResponseEntity.ok(isValid);
    }
}
