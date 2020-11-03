import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Desafio15 {
    public static void main(String[] args) {
        System.out.println("Input: ");
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        while (input.length != 2 || !input[0].matches("^\\d+$") || !input[1].matches("^\\d+$") || input[0].equals("0")
                || input[1].equals("0")) {
            System.err.println("ERROR: Bad Input. Input should be: <Positive Integer> <Positive Integer>");
            input = sc.nextLine().split(" ");
        }
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        List<String> listOfWords = new ArrayList<>();
        String word;
        for (int i = 0; i < N; i++) {
            word = sc.nextLine();
            while (word.split(" ").length != 1) {
                System.err.println("Error: Bad input!");
                word = sc.nextLine();
            }
            listOfWords.add(word);
        }
        sc.close();
        String text = buildJustifiedString(K, listOfWords);
        System.out.println("\nOutput:");
        System.out.println(text);
    }

    public static String buildJustifiedString(int K, List<String> wordsList) {
        int numberOfChars = 0;
        int lastWordsIndex = 0;

        StringBuilder sb = new StringBuilder();
        int wordsLen, spaceLen, eachLineLength, extraLineLenth, remainder, numberOfSpaces;

        for (int i = 0; i < wordsList.size(); i++) {
            numberOfChars += wordsList.get(i).length();

            if (numberOfChars - lastWordsIndex + i > K) {
                wordsLen = numberOfChars - wordsList.get(i).length();
                spaceLen = K - wordsLen;
                eachLineLength = 1;
                extraLineLenth = 0;
                remainder = i - lastWordsIndex - 1;

                if (remainder > 0) {
                    eachLineLength = spaceLen / remainder;
                    extraLineLenth = spaceLen % remainder;
                }

                for (int k = lastWordsIndex; k < i - 1; k++) {
                    sb.append(wordsList.get(k));

                    numberOfSpaces = 0;
                    while (numberOfSpaces < eachLineLength) {
                        sb.append(" ");
                        numberOfSpaces++;
                    }

                    if (extraLineLenth > 0) {
                        sb.append(" ");
                        extraLineLenth--;
                    }
                }

                sb.append(wordsList.get(i - 1));
                // if just one word in line, fill the rest of size with spaces
                while (sb.length() < K) {
                    sb.append(" ");
                }

                sb.append("\n");

                lastWordsIndex = i;
                numberOfChars = wordsList.get(i).length();
            }
        }

        // go from the first of the last words until reach the ultimate last word
        // (exclusive)
        for (int i = lastWordsIndex; i < wordsList.size() - 1; i++) {
            numberOfChars += wordsList.get(i).length();
            sb.append(wordsList.get(i) + " ");
        }

        // adding last word and last spaces untill reach the maximum size
        sb.append(wordsList.get(wordsList.size() - 1));
        while (sb.length() < K) {
            sb.append(" ");
        }

        return sb.toString();
    }
}
