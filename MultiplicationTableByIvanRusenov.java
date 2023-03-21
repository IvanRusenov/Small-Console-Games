import java.util.Random;
import java.util.Scanner;

public class MultiplicationTableByIvanRusenov {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("*?*?* MULTIPLICATION TABLE *?*?*");
        System.out.println("You can leave program at any time by pressing \"q\"");
        System.out.println();

        Random random = new Random();
        int countGessed = 0;
        int bestScore = 0;

        while (true){

            int multiplicand = random.nextInt(10)+1;
            int multiplier = random.nextInt(10)+1;
            int product = multiplicand * multiplier;

            System.out.printf("HOW MUCH IS %d X %d  = ",multiplicand,multiplier);

           String input = scan.nextLine();

           if (input.equalsIgnoreCase("q")){
               break;

           }else if (isInputDigit(input)){

               if (Integer.parseInt(input) == product){

                   countGessed++;
                   System.out.printf("Excellent! Guessed %d at row\n",countGessed);

                   if (bestScore < countGessed){

                       bestScore = countGessed;
                   }

               }else{

                   System.out.printf("Not exactly.The product is %d\n",product);
                   countGessed = 0;

               }



           }else {

               System.out.println("Invalid input!");
               countGessed = 0;
           }


        }

        System.out.println();
        System.out.println("Your best score is: " + bestScore);
        System.out.println("Goodbye!");

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

}
