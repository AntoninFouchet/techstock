package com.techstock.dto;

import com.techstock.model.Employee;

public class EmployeeDTO {
    private Long id;
    private String nomComplet; // Petite astuce pro : on peut formater ici
    private String email;
    private String poste;

    // Constructeur qui transforme l'Entity en DTO
    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.nomComplet = employee.getPrenom() + " " + employee.getNom();
        this.email = employee.getEmail();
        this.poste = employee.getPoste();
    }

    // Getters uniquement (le DTO est souvent en lecture seule vers le front)
    public Long getId() { return id; }
    public String getNomComplet() { return nomComplet; }
    public String getEmail() { return email; }
    public String getPoste() { return poste; }
}