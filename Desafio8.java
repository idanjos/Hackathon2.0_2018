import java.util.ArrayList;
import java.util.Scanner;

public class Desafio8 {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        String[] firstInp = inputReader.nextLine().split(" ");

        while (firstInp.length != 2 || !firstInp[0].matches("^\\d+$") || !firstInp[1].matches("^\\d+$")) {
            System.out.println("ERROR: Bad Input!");
            firstInp = inputReader.nextLine().split(" ");
        }

        int N = Integer.parseInt(firstInp[0]);
        int K = Integer.parseInt(firstInp[1]);

        String[] numbers = inputReader.nextLine().split(" ");
        while (numbers.length != N) {
            System.out.println("ERROR: Bad Input!");
            numbers = inputReader.nextLine().split(" ");
        }

        inputReader.close();

        int i = 0;
        ArrayList<ArrayList<String>> allPosibilities = new ArrayList<>();

        // While we havent reached the end of the sequence given
        while (i < N) {

            // Create a substring of consecutive numbers
            ArrayList<String> tempString = new ArrayList<>();
            tempString.add(numbers[i]);
            i++;

            while (i < N && Integer.parseInt(numbers[i]) == Integer.parseInt(numbers[i - 1]) + 1) {
                tempString.add(numbers[i]);
                i++;
            }

            // Add 4 more numbers to that sequence
            int k = 0;

            while (k < K) {
                int nextNumb = Integer.parseInt(tempString.get(tempString.size() - 1)) + 1;
                // Take into consideration whether the sequence gets continued in the given
                // numbers or not
                if (i < N && numbers[i].equals(nextNumb + "")) {
                    i++;
                    tempString.add(nextNumb + "");
                } else {
                    k++;
                    tempString.add(nextNumb + "");
                }
            }

            allPosibilities.add(tempString);
        }

        int biggestSequence = allPosibilities.get(0).size();
        int biggestSequenceIndex = 0;

        // Get the biggest of all possibilities
        for (int j = 1; j < allPosibilities.size(); j++) {
            if (allPosibilities.get(j).size() > biggestSequence) {
                biggestSequence = allPosibilities.get(j).size();
                biggestSequenceIndex = j;
            }
        }

        System.out.println(allPosibilities.get(biggestSequenceIndex));

    }
}