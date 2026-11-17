package org.example;

public class Util {

    public static String getNameWithAge(Employee employee) {
        return String.format("Imię: %s, wiek: %d", employee.name(), employee.age());
    }
}