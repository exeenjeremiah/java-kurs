package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];

        initializeBoard(board);
        int moves = 0;
        char currentPlayer = 'X';

        while (moves < 9) {
            showBoard(board);
            System.out.println("Gracz " + currentPlayer + ", podaj wiersz i kolumnę");
            int row = scanner.nextInt() - 1;
            int column = scanner.nextInt() - 1;

            if (checkIfFieldIsNotTaken(board, row, column)) continue;
            board[row][column] = currentPlayer;
            moves++;

            if (checkWin(board, currentPlayer)) {
                showBoard(board);
                System.out.println("Gracz " + currentPlayer + " wygrywa!");
                break;
            }

            if (moves == 9) {
                showBoard(board);
                System.out.println("Remis!");
                break;
            }
            currentPlayer = changePlayer(currentPlayer);
        }
    }

    private static char changePlayer(char currentPlayer) {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
        return currentPlayer;
    }

    private static boolean checkIfFieldIsNotTaken(char[][] board, int row, int column) {
        if (board[row][column] != ' ') {
            System.out.println("To pole jest już zajęte");
            return true;
        }
        return false;
    }

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void showBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            System.out.println(
                    board[i][0] + " | " +
                            board[i][1] + " | " +
                            board[i][2]);
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    private static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                    board[i][1] == player &&
                    board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player &&
                    board[1][i] == player &&
                    board[2][i] == player) {
                return true;
            }
        }

        if (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player) {
            return true;
        }
        return false;
    }
}