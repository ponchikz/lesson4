package lesson4;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String[][] field = initField(3);
        printField(field);

        while (true) {
            humaMakeTurn(field);
            printField(field);
            if (isWinner(field, "X")) {
                System.out.println("X, выйграл");
                break;
            }
            if (isDraw(field)) {
                break;
            }

            iaMakeTurn(field);
            printField(field);
            if (isWinner(field, "0")) {
                System.out.println("0, выйграл");
                break;
            }
            if (isDraw(field)) {
                break;
            }
        }
    }

    public static String[][] initField(int size) {
        String[][] field = new String[size][size];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = "*";
            }
        }
        return field;
    }

    public static void printField(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humaMakeTurn(String[][] field) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            if ((x >= 0 && x < field.length) && (y >= 0 && y < field.length)) {
                if (field[x][y].equals("*")) {
                    field[x][y] = "X";
                    break;
                } else {
                    System.out.println("Тут, занято, ходите снова");
                }
            } else {
                System.out.println("За пределами поля, переигрывайте");
            }
        }
    }

    public static void iaMakeTurn(String[][] field) {
        Random random = new Random();
        while (true) {
            int x = random.nextInt(field.length);
            int y = random.nextInt(field.length);
            if ((x >= 0 && x < field.length) && (y >= 0 && y < field.length)) {
                if (field[x][y].equals("*")) {
                    field[x][y] = "0";
                    break;
                }
            }
        }
    }

    public static boolean isWinner(String[][] field, String turn) {
        if ((field[0][0].equals(turn) && field[0][1].equals(turn) && field[0][2].equals(turn)) ||
            (field[1][0].equals(turn) && field[1][1].equals(turn) && field[1][2].equals(turn)) ||
            (field[2][0].equals(turn) && field[2][1].equals(turn) && field[2][2].equals(turn)))
        {
            return true;
        }
        else if ((field[0][0].equals(turn) && field[1][0].equals(turn) && field[2][0].equals(turn)) ||
                 (field[0][1].equals(turn) && field[1][1].equals(turn) && field[2][1].equals(turn)) ||
                 (field[0][2].equals(turn) && field[1][2].equals(turn) && field[2][2].equals(turn)))
        {
            return true;
        }
        else if ((field[0][0].equals(turn) && field[1][1].equals(turn) && field[2][2].equals(turn)) ||
                 (field[0][2].equals(turn) && field[1][1].equals(turn) && field[2][0].equals(turn)))
        {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isDraw(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j].equals("*")) {
                    return false;
                }
            }
        }

    }
}


