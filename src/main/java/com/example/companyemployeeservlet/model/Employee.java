package com.example.companyemployeeservlet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    private int id;
    private String name;
    private String surname;
    private String email;
    private Company company;


}
