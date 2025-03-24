package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    System.out.println("EASY");
    List<Person> people = List.of(
            Person.builder().name("Nurik").age(19).city("Almaty").build(),
            Person.builder().name("Arlan").age(13).city("Shymkent").build(),
            Person.builder().name("Nura").age(17).city("Almaty").build(),
            Person.builder().name("Yers").age(21).city("Shymkent").build(),
            Person.builder().name("Garik").age(18).city("Aktobe").build()
    );

    System.out.println("MEDIUM");
    List<Person> adults = people.stream()
            .filter(person -> person.getAge() > 18)
            .collect(Collectors.toList());
    System.out.println(adults);

    double AvgAge = people.stream()
            .mapToInt(Person::getAge)
            .average()
            .orElse(0);
    System.out.println(AvgAge);

    List<String> whoAlmaty = people.stream()
            .filter(person -> "Almaty".equals(person.getCity()))
            .map(Person::getName)
            .collect(Collectors.toList());
    System.out.println(whoAlmaty);

    Map<String, Integer> nameAge = people.stream()
            .collect(Collectors.toMap(Person::getName, Person::getAge));
    System.out.println(nameAge);

    System.out.println("HARD");
    Company company = Company.builder()
            .name("Kontora")
            .employees(List.of(
                    Person.builder().name("Arman").age(26).build(),
                    Person.builder().name("Aisulu").age(24).build(),
                    Person.builder().name("Yernar").age(29).build(),
                    Person.builder().name("Zhomart").age(21).build(),
                    Person.builder().name("Diyar").age(22).build()
            ))
            .build();


    company.getEmployees().stream()
            .sorted(Comparator.comparingInt(Person::getAge).reversed())
            .limit(3)
            .forEach(person -> System.out.println(person.getName() + person.getAge()));

    company.getEmployees().stream()
            .filter(person -> person.getAge() > 25)
            .forEach(person -> System.out.println(person.getName()));

    double AvgCompanyAge = company.getEmployees().stream()
            .mapToInt(Person::getAge)
            .average()
            .orElse(0);
    System.out.println(AvgCompanyAge);
  }
}