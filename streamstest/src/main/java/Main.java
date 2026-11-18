import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Adam", "COMPLETED",
                        List.of("Laptop", "Mouse"), 4200),
                new Order(2, "Anna", "COMPLETED",
                        List.of("Keyboard", "Mouse"), 350),
                new Order(3, "Adam", "CANCELLED",
                        List.of("Monitor"), 1200),
                new Order(4, "Piotr", "COMPLETED",
                        List.of("Laptop", "Monitor"), 5500),
                new Order(5, "Anna", "COMPLETED",
                        List.of("Mouse", "Headphones"), 600),
                new Order(6, "Adam", "COMPLETED",
                        List.of("Keyboard", "Monitor"), 1500)
        );

        String products = orders.stream()
                .filter(order -> order.status().equals("COMPLETED"))
                .flatMap(order -> order.products().stream())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));

        System.out.println(products);


        Map<String, List<Integer>> customerOrders = orders.stream()
                .filter(order -> order.status().equals("COMPLETED"))
                .collect(Collectors.groupingBy(Order::customer,
                        Collectors.mapping(Order::id, Collectors.toList())));

        System.out.println(customerOrders);

        Map<String, Double> customerTotalOrder = orders.stream()
                .filter(order -> order.status().equals("COMPLETED"))
                .collect(Collectors.toMap(Order::customer, Order::total, Double::sum));

        System.out.println(customerTotalOrder);

        List<Integer> mostExpensiveOrder = orders.stream()
                .filter(order -> order.status().equals("COMPLETED"))
                .sorted(Comparator.comparingDouble(Order::total).reversed())
                .limit(3)
                .map(Order::id)
                .toList();

        System.out.println(mostExpensiveOrder);

    }
}