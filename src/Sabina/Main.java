package Sabina;

import java.util.*;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
    static ArrayList<GameResult> users = new ArrayList<>();

    public static void main(String[] args) {
        do {
            String userName = askString("Please enter your name: ");



            int myNum = rand.nextInt(100) + 1;
            long t1 = System.currentTimeMillis();
            System.out.println("Expected number: " + myNum); // TODO Remove this line once the game is finished

            String answer;


            boolean userWon = false;
            for (int i = 0; i < 10; i++) {
                int userNum = askInt("Please, enter your guess: ", 1, 100);



                if (userNum == myNum) {
                    long t2 = System.currentTimeMillis();
                    GameResult r = new GameResult();
                    r.name = userName;
                    r.triesCount = i + 1;
                    r.time = t2 - t1;
                    users.add(r);
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

            users.sort(Comparator.comparing((r) -> r.triesCount));

        for (GameResult result : users) {
            System.out.printf("%s \t\t\t %d %d\n", result.name, result.triesCount, result.time / 1000);

        }
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
            } catch (InputMismatchException ex) {
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


    static String askString(String msg) {
        System.out.println(msg);
        String answer = scan.next();
        return answer;


    }

    }











// write your code here


