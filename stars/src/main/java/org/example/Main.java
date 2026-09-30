package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj wysokość");
        int a = scanner.nextInt();
//        System.out.println("Podaj szerokość");
//        int b = scanner.nextInt();
//
//        for (int i = 0; i < a; i++) {
//
//            for (int j = 0; j < b; j++) {
//
//                if (i == 0 || i == a - 1 || j == 0 || j == b - 1) {
//                    System.out.print("*");
//                } else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println("");
//        }
//    }
//}

        for (int i = 0; i < a; i++) {
            for (int j = a - i - 1; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
