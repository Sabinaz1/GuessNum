package Sabina;

import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int myNum = rand.nextInt(100) + 1;
        System.out.println("Expected number: " + myNum);

        String answer;
        do {

            boolean userWon = false;
            for (int i = 0; i < 10; i++) {
                int userNum = askInt("Please, enter your guess: ", 1, 100);

                if (userNum == myNum) {
                    System.out.println("You won!");
                    userWon = true;
                    break;
                } else if (userNum > myNum) {
                    System.out.println("My number is smaller than yours");
                } else {
                    System.out.println("My number is bigger than yours");
                }


            }

            if (!userWon) {
                System.out.println("You lost!");


            }



        } while (askYesNo("Would you like to play again? (y/n))"));

        System.out.println("Goodbye!");
    }

    static int askInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.println(msg);
                int answer = scan.nextInt();
                if (answer >= min && answer <= max) {
                    return answer;
                }
            } catch(InputMismatchException ex) {
                System.out.println("It isn't a number");
                scan.next();
            }


            System.out.printf("Please enter your number from %d to %d\n", min, max);
        }
    }

    static boolean askYesNo(String msg) {
        while (true) {
            System.out.println(msg);
            String answer = scan.next();
            boolean isY = answer.equalsIgnoreCase("y");
            boolean isN = answer.equalsIgnoreCase("n");
            if (isY || isN) {
                return isY;
            }
            System.out.println("Enter 'y' or 'n'");

        }
    }
}










// write your code here


