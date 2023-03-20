import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's PLAY!");
        System.out.println("You can leave at any time by pressing \"q\"!");
        System.out.println("I thought of a number between 1 and 100. Try to guess it!");

        System.out.print("Enter your number: ");

        String input = scanner.nextLine();
        Random random = new Random();
        int numToGuess = random.nextInt(99) + 1;
        int counter = 0;

        while (!input.equalsIgnoreCase("q")) {

            counter++;
            boolean isGuessed = false;

            if (isInputDigit(input)) {

                int number = Integer.parseInt(input);

                if (isValidNumber(number)) {

                    if (number < numToGuess) {

                        System.out.println("UP");

                    } else if (number > numToGuess) {

                        System.out.println("DOWN");

                    } else {

                        System.out.printf("Well done! You guessed it from the %d time!\n",counter);
                        isGuessed = true;
                        counter = 0;

                    }

                } else {

                    System.out.println("Invalid number");
                }

                if (isGuessed) {

                    System.out.println("Press \"Y\" if you want to play again?");

                    String answer = scanner.nextLine();

                    if (answer.equalsIgnoreCase("y")) {
                        System.out.println("Excellent");
                        System.out.println("I thought of another number between 1 and 100. Try to guess it again");
                        numToGuess = random.nextInt(100);
                        System.out.print("Enter your number: ");
                        input = scanner.nextLine();
                        continue;

                    } else {

                        System.out.println("Goodbye !!!");
                        break;

                    }

                }

            } else {

                System.out.println("Invalid number");

            }

            System.out.print("Enter your number: ");
            input = scanner.nextLine();

        }

    }

    public static boolean isInputDigit(String input) {

        if (input.isEmpty()){

            return false;

        }else {

            for (char ch : input.toCharArray()) {

                if (ch < '0' || ch > '9') {

                    return false;

                }

            }

            return true;

        }

    }

    public static boolean isValidNumber(int number) {

        return number > 0 && number <= 100;

    }
}
