package com.techstock.controller;

import com.techstock.dto.EmployeeDTO;
import com.techstock.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:5173") // Autoriser React (Vite)
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<EmployeeDTO> getAll() {
        return service.getAllEmployees();
    }
}