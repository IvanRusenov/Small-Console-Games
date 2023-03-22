import java.util.*;
import java.util.concurrent.TimeUnit;

public class LotteryByIvanRusenov {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Random random = new Random();
        String answer = "Y";
        while (answer.equalsIgnoreCase("y")) {

            List<Integer> lotteryNumbers = new ArrayList<>();

            for (int i = 0; i < 6; i++) {

                int number = random.nextInt(49) + 1;

                if (!lotteryNumbers.contains(number)) {

                    lotteryNumbers.add(number);

                } else {

                    i--;

                }
            }

            System.out.println("Please enter 6 numbers between 1 and 49 ");
            List<Integer> userNumbers = new ArrayList<>();

            for (int i = 1; i <= 6; i++) {

                System.out.printf("Enter number %d: ", i);
                int number = Integer.parseInt(scan.nextLine());
//                System.out.println();

                if (number > 0 && number <= 49) {

                    if (userNumbers.contains(number)) {

                        System.out.println("You already entered this number! Try again!");
                        i--;

                    } else {

                        userNumbers.add(number);

                    }

                } else {

                    System.out.println("Invalid number! Try again!");
                    i--;

                }

            }

            System.out.println("Your numbers are: ");
            userNumbers.forEach(e -> System.out.printf("%d ", e));
            System.out.println();
            System.out.println("Lottery numbers are: ");
            System.out.println("********************");

            for (Integer num : lotteryNumbers) {

                try {
                    TimeUnit.SECONDS.sleep(2);

                } catch (InterruptedException e) {

                    throw new RuntimeException(e);

                }

                System.out.printf("%d ", num);
            }

            System.out.println();
            System.out.println("********************");
            System.out.println();
            int counter = 0;
            List<Integer> commonNumbers = new ArrayList<>();

            for (Integer userNumber : userNumbers) {

                for (Integer lotteryNumber : lotteryNumbers) {

                    if (userNumber == lotteryNumber) {
                        counter++;
                        commonNumbers.add(userNumber);
                    }

                }

            }

            if (commonNumbers.size() > 0) {

                System.out.printf("CONGRATULATIONS!!! You guess %d numbers\n", counter);
                commonNumbers.forEach(n -> System.out.printf("%d ", n));
                System.out.println();

            } else {

                System.out.println("Sorry! You don't guess any number");

            }

            System.out.println("Type \"Y\" if you want to play again: ");
            answer = scan.nextLine();

        }

        System.out.println("GOODBYE");
        // TODO: 18.3.2023 г. statistics how match games ,how match points
        //  or numbers guessedt or how mach two's,three's,JACKPOT

    }
}
