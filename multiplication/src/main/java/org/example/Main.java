package org.example;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }

        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {

                if ((i + j) % 2 == 0) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}