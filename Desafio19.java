import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Desafio19 {

    public static void checkDifferents(String[] allDigits) {

        ArrayList<Integer> differentDigits = new ArrayList<>();

        // Add to a list all the different digits in the array
        for (int i = 0; i < allDigits.length; i++) {
            if (differentDigits.contains(Integer.parseInt(allDigits[i]))) {
                continue;
            }
            differentDigits.add(Integer.parseInt(allDigits[i]));
        }

        // Size of list is gonna be equal to the ammount of unique digits
        if (differentDigits.size() < 2) {
            System.out.println("ERRO! O numero de digitos diferentes é menor que 2");
            System.exit(1);
        }
    }

    public static int nextStep(String[] allDigits) {
        String numberString = "";

        // Transform the number in ascending order
        Arrays.sort(allDigits);
        for (int i = 0; i < allDigits.length; i++) {
            numberString = numberString + allDigits[i];
        }

        int numberCresc = Integer.parseInt(numberString);

        // Transform the number in descending order
        numberString = "";
        for (int i = allDigits.length - 1; i > -1; i--) {
            numberString = numberString + allDigits[i];
        }

        int numberDec = Integer.parseInt(numberString);

        int number = numberDec - numberCresc;
        return number;
    }

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        int number = inputReader.nextInt();

        inputReader.close();

        if (number < 1000) {
            System.out.println("ERRO! O numero tem de ter pelo menos 4 digitos");
            System.exit(1);
        }

        String numberString = number + "";
        String[] allDigits = numberString.split("");

        checkDifferents(allDigits);

        // Iterate the steps until we get the Kaprekar number
        int counter = 0;
        while (number != 6174) {
            number = nextStep(allDigits);
            numberString = number + "";
            while (numberString.length() < 4) {
                numberString = 0 + numberString;
            }

            allDigits = numberString.split("");

            counter++;
        }

        System.out.println(counter);
    }

}