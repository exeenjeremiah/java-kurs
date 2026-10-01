package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Podaj wysokość");
//        int a = scanner.nextInt();
//        System.out.println("Podaj szerokość");
//        int b = scanner.nextInt();
//
//        for (int i = 0; i < a; i++) {
//            for (int j = 0; j < b; j++) {
//                if (i == 0 || i == a - 1 || j == 0 || j == b - 1) {
//                    System.out.print("*");
//                } else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println("");
//        }
        System.out.println("Podaj wysokość");
        int a = scanner.nextInt();

        for (int i = 1; i < a; i++) {
            System.out.print(" ".repeat(a - i));
            System.out.print("*".repeat(2 * i - 1));
            System.out.println();
        }
    }
}
//        System.out.println("Podaj swoje hasło:");
//        String password = scanner.nextLine();
//
//        boolean unique = true;
//        for (int i = 0; i < password.length(); i++) {
//            for (int j = i + 1; j < password.length(); j++) {
//                if (password.charAt(i) == password.charAt(j)) {
//                    unique = false;
//
//                }
//            }
//            break;
//        }
//        if (unique) {
//            System.out.println("Hasło ma unikalne znaki");
//        } else {
//            System.out.println("Hasło ma powtarzalne znaki");
//        }
//    }
//}