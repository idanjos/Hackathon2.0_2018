import java.util.ArrayList;
import java.util.Scanner;

public class Desafio7 {

    public static ArrayList<String> anagramGetter(String[] phrase, String word, int wordAmmount) {
        ArrayList<String> anagramsFound = new ArrayList<>();
        anagramsFound.add(word);

        // Go through all words
        for (int j = 0; j < wordAmmount; j++) {
            String tempWord = phrase[j];

            // Ignore the word were getting anagrams for (otherwise drone would output drone
            // as an anagram)
            if (tempWord.equals(word)) {
                continue;
            }

            // Anagrams only exist if the length of the words is the same
            if (tempWord.length() == word.length()) {
                boolean anagram = true;

                // Anagrams only exist if all letters that exist in word exist in the other
                for (int i = 0; i < word.length(); i++) {
                    if (word.indexOf(tempWord.charAt(i)) == -1) {
                        anagram = false;
                    }
                }

                if (anagram) {
                    anagramsFound.add(tempWord);
                }
            }
        }

        return anagramsFound;
    }

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        int wordAmmount = Integer.parseInt(inputReader.nextLine());
        while (wordAmmount < 3) {
            System.out.println("ERRO! Precisa de inserir no minimo 3 palavaras");
            wordAmmount = Integer.parseInt(inputReader.nextLine());
        }

        String phrase = inputReader.nextLine();
        String[] words = phrase.split(" ");

        while (wordAmmount != words.length) {
            System.out.println("ERRO! Numero de palavras fornecidas nao equivale ao esperado");
            phrase = inputReader.nextLine();
            words = phrase.split(" ");
        }

        ArrayList<ArrayList<String>> anagrams = new ArrayList<>();

        // Go through all words given and check for anagrams
        for (String word : words) {

            ArrayList<String> anagramTest = anagramGetter(words, word, wordAmmount);

            if (anagramTest.size() > 1) {
                boolean containFlag = false; // Flag to check if we already found that anagram (f.ex drone dreno ==
                                             // dreno drone)

                // Check if we already added that pair
                for (int i = 0; i < anagrams.size(); i++) {
                    if (anagrams.get(i).contains(word)) {
                        containFlag = true;
                        break;
                    }
                }
                if (containFlag) {
                    continue;
                }

                anagrams.add(anagramTest);
            }
        }

        if (anagrams.size() != 0) {
            ArrayList<String> biggestList = anagrams.get(0);

            for (int i = 1; i < anagrams.size(); i++) {
                if (anagrams.get(i).size() > biggestList.size()) {
                    biggestList = anagrams.get(i);
                }
            }

            System.out.println(biggestList);
        } else {
            System.out.println("Nao existem anagramas");
        }

        inputReader.close();
    }
}