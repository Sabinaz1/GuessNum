package Sabina;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
    static ArrayList<GameResult> leaderBoard = new ArrayList<>();

    public static void main(String[] args) {
        loadResults();

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
                    r.setName(userName);
                    r.setTriesCount(i + 1);
                    r.setTime(t2 - t1);
                    leaderBoard.add(r);
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

        showResult2();
        file();

        System.out.println("Goodbye!");
    }

    private static void loadResults() {
     File file = new File("myfile.txt");
     try (Scanner in = new Scanner(file)) {
         while (in.hasNext()) {
             GameResult r = new GameResult();
             String name = in.next();
             int tries = in.nextInt();
             long time = in.nextLong();
             r.setName(name);
             r.setTriesCount(tries);
             r.setTime(time);
             leaderBoard.add(r);

         }
     }catch (IOException e){
         System.out.println("Cannot read leader board");
     }
    }

   /* private static void showResults() {
        leaderBoard.sort(Comparator.
                comparing(GameResult::getTriesCount)
                .thenComparing(GameResult::getTime));

        for (GameResult result : leaderBoard) {
            System.out.printf("%s \t\t\t %d %d\n",
                    result.getName(),
                    result.getTriesCount(),
                    result.getTime() / 1000);

        } */

        private static void showResult2(){
                leaderBoard.stream()
                        .sorted(Comparator
                                .comparingInt(GameResult::getTriesCount)
                                .thenComparing(GameResult::getTime))
                        .limit(5)
                        .forEach(r -> System.out.printf("%s \t\t\t %d \t\t\t %d\n",
                                r.getName(),
                                r.getTriesCount(),
                                r.getTime() / 1000));




    }

        private static void file(){
        File file = new File("myfile.txt");
        try(PrintWriter out = new PrintWriter(file)) {
            for (GameResult result : leaderBoard) {
                out.printf("%s %d %d\n",
                        result.getName(),
                        result.getTriesCount(),
                        result.getTime() / 1000);


            }
        }catch (IOException e) {
            System.out.println("Something went wrong. Try again!");

        } ;

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


