package org.example;


import lombok.*;
import java.util.List;

@Builder
@Data
public class Company {
    private String name;
    private List<Person> employees;
}
