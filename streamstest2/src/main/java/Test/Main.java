package Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Adam", "IT", 28, 8500),
                new Employee(2, "Anna", "HR", 35, 7200),
                new Employee(3, "Piotr", "IT", 42, 12500),
                new Employee(4, "Kasia", "HR", 29, 6800),
                new Employee(5, "Marek", "IT", 31, 9500),
                new Employee(6, "Ola", "Finance", 45, 14000),
                new Employee(7, "Tomek", "Finance", 26, 7500),
                new Employee(8, "Ewa", "IT", 38, 11000)
        );

        Map<String, Double> avgSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::department,
                        Collectors.averagingDouble(Employee::salary)));
        System.out.println(avgSalary);

    }
}