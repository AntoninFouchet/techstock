package com.techstock.service;

import com.techstock.dto.EmployeeDTO;
import com.techstock.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<EmployeeDTO> getAllEmployees() {
        // On récupère les entités et on les transforme en DTOs
        return repository.findAll().stream()
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
    }
}