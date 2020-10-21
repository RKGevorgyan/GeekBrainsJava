package lesson3;

import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Scanner scanner = new Scanner(System.in);
        int choose = -1;
        while (true) {
            System.out.println("If you want to guess number, write - \"1\"; or to guess word - \"2\"; to quit \"-1\"");
            choose = scanner.nextInt();
            if (choose == 1) {
                playGuessNumber();
            }
            else if (choose == 2)
                playGuessWord(words);
            else if (choose==-1) break;
        }
        scanner.close();
    }
    // exercise 1
    public static void playGuessNumber(){
        int randomNumber = (int) (Math.random()*10);
        Scanner scanner = new Scanner(System.in);
        int number  = -1;
        do {
            int numberOfAttempts = 3;
            for (int i = 0; i < 3; i++) {
                if (numberOfAttempts == 1) {
                    System.out.println("Try to guess number from 0-9. You have " + numberOfAttempts + " attempt");
                } else {
                    System.out.println("Try to guess number from 0-9. You have " + numberOfAttempts-- + " attempts");
                }
                if (scanner.nextInt() == randomNumber) {
                    System.out.println("You Win!");
                    return;
                }
            }
            System.out.println("You lose =(");
            System.out.println("Don't you want to repeat the game? 1 - Yes; 0 - No.");

            while(true) {
                number = scanner.nextInt();
                if (!(number == 1 || number == 0)) {
                    System.out.println("Choose right number 1 - Yes or 0 - No");
                }else break;
            }
        } while (number!=0);
    }
    // exercise 2
    public static void playGuessWord(String[] words){
        // choosing random word from given array
        String randomWord = words[(int) (Math.random()* (words.length-1))];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Try to guess the word:");
        while (true) {
            // reading user's input
            String fromUser = scanner.nextLine();
            if (fromUser.equals(randomWord)) {
                System.out.println("You win!");
                break;
            } else {
                boolean flag = false;
                // checking if the array contains user's input
                for (String s : words){
                    if (s.equals(fromUser)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) System.out.println("I don't know this word");

                System.out.println("Try again");
                char[] charsWord = randomWord.toCharArray();
                char[] charsUser = fromUser.toCharArray();
                int length = 0;
                int quantity = 0;
                length = Math.min(charsWord.length, charsUser.length);
                for (int i = 0; i < length; i++) {
                    if (charsUser[i] == charsWord[i]) {
                        quantity++;
                        System.out.print(charsUser[i]);
                    } else {
                        quantity++;
                        System.out.print("#");
                    }
                }
                for (int i = 0; quantity < 15; quantity++)
                    System.out.print("#");
                System.out.println();
            }
        }
    }
}
