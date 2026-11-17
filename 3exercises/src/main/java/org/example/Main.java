package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "hello world",
                "java streams",
                "world of code"
        );

        String result = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));

        System.out.println(result);
    }
}



//public class Main {
//    //  ZADANIE 8 Filtrowanie, mapowanie, grupowanie
//    public static void main(String[] args) {
//
//        List<Employee> employees = Arrays.asList(
//                new Employee("Michał", 38, "PMD"),
//                new Employee("Kasia", 23, "SMD"),
//                new Employee("Kacper", 28, "PMD"),
//                new Employee("Błażej", 22, "SMD"),
//                new Employee("Zbychu", 35, "FMD")
//        );
//
//        List<String> names = employees.stream()
//                .filter(employee -> employee.age() > 25)
//                .map(Employee::name)
//                .sorted()
//                .toList();
//
//        System.out.println("Pracownicy powyżej 25 lat: " + names);
//
//
//        Map<String, List<String>> grouped = employees.stream()
//                .collect(Collectors.groupingBy(Employee::department, Collectors.mapping(Util::getNameWithAge,
//                        Collectors.toList())));
//
//        System.out.println("Pracownicy według działów: ");
//
//        grouped.forEach((department, workers) ->
//                System.out.println(department + ": " + workers));
//    }
//}



//    // ZADANIE 7 Filtrowanie listy za pomocą Predicate
//    public static List<Integer> filterNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
//        return numbers.stream()
//                .filter(predicate)
//                .toList();
//    }
//
//    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 10, 15, 20);
//        Predicate<Integer> isEven = number -> number % 2 == 0;
//        List<Integer> evenNumbers = filterNumbers(numbers, isEven);
//        System.out.println(evenNumbers);
//
//        Function<String, String> removeSpaces = text -> text.trim();
//        Function<String, String> upperCase = text -> text.toUpperCase();
//        Function<String, String> result = removeSpaces.andThen(upperCase);
//        System.out.println(result.apply(" hello world "));
//    }
//}