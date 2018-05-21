package lesson2;

import java.util.Scanner;

/**
 *
 * @author Marco Van der Eecekn
 */
public class Lesson2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("What is the word you wish to guess? ");
        String guessedWord = input.next();
        String[] answer = new String[guessedWord.length()];
        String[] incorrectGuesses = new String[8];
        boolean userHasWon = false;

        int userIncorrectGuesses = 0;
        int userScore = 0;

        //save to an array.
        for (int i = 0; i < answer.length; i++) {
            answer[i] = guessedWord.substring(i, i + 1);
        }

        String[] userGuesses = new String[8];

        for (int i = 0; i < 20; i++) {
            System.out.println("");
        }

        while (userIncorrectGuesses < 8 || userIncorrectGuesses == -1) {

            System.out.println("User what letter would you like to guess?");
            String userGuess = input.next();

            if (userGuess.length() > 1) {
                System.out.println("Invalid, only one character is allowed to be guessed at a time");
            }

            for (int i = 0; i < userGuesses.length; i++) {
                if (userGuesses[i] == null) {
                    userGuesses[i] = userGuess;
                    break;
                }
            }

            for (String userInput : userGuesses) {
                if (userInput == null) {
                    userInput = userGuess;
                    break;
                }

            }

            for (int i = 0; i < answer.length; i++) {
                if (userGuess.equalsIgnoreCase(answer[i])) {
                    System.out.println("You guessed the correct letter!");
                    //don't lose a point and the guess is added to the previous letters guessed
                    userGuesses[i] = userGuess;
                    userScore++;
                    if (userScore == answer.length) {
                        userHasWon = true;
                    }
                    break;
                } else if (i == answer.length - 1) {
                    for (int j = 0; j < userGuesses.length; j++) {
                        if (userGuesses[j] == null) {
                            userGuesses[j] = userGuess;
                            break;
                        }
                    }
                    userIncorrectGuesses++;
                    if (userIncorrectGuesses == 8) {
                        userHasWon = false;
                    }
                    System.out.println("That letter is not correct");
                }
            }

            //print out the letters and _ if null.
            if (userHasWon) {
                break;
            }

        }

        if (userHasWon) {
            System.out.println("You won the game!");
        } else {
            System.out.println("You have lost. :(");
        }

    }

}
