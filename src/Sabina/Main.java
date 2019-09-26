package Sabina;

import org.w3c.dom.ls.LSOutput;

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
                System.out.println("Enter your guess: ");
                int userNum = scan.nextInt();

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
            System.out.println("Would you like to play again? (y/n)");
            answer = scan.next();
        } while (answer.equals("y")) ;
    }
}


// write your code here


