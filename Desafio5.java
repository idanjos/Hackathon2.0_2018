import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class Desafio5 {
    public static int[] getEquilibrium(int[] unballancingWeights, int[] balancingWeights) {
        int equilibriumNumber = Math.abs(unballancingWeights[0] - unballancingWeights[1]);

        Arrays.sort(balancingWeights);
        int[] pickedWeights = new int[2];

        for (int i = 0; i < balancingWeights.length; i++) {

            // First check if adding only this weight is enough
            if (balancingWeights[i] == equilibriumNumber) {
                if (unballancingWeights[0] > unballancingWeights[1]) {
                    pickedWeights[0] = balancingWeights[i];
                    pickedWeights[1] = -1;
                } else {
                    pickedWeights[0] = -1;
                    pickedWeights[1] = balancingWeights[i];
                }
                return pickedWeights;
            }

            // Search through all number combos to see if any equal the equilibrium number
            // (note we dont need to check combos with numbers that came before since we're
            // using Abs)
            for (int j = (i + 1); j < balancingWeights.length; j++) {
                // Check if we can get equilibrium by putting one weight on each side
                if (Math.abs(balancingWeights[i] - balancingWeights[j]) == equilibriumNumber) {
                    if (unballancingWeights[0] > unballancingWeights[1]) {
                        pickedWeights[0] = balancingWeights[j];
                        pickedWeights[1] = balancingWeights[i];
                    } else {
                        pickedWeights[0] = balancingWeights[i];
                        pickedWeights[1] = balancingWeights[j];
                    }

                    return pickedWeights;

                    // Check if we can get equilibrium by putting both weights on one side
                } else if (Math.abs(balancingWeights[i] + balancingWeights[j]) == equilibriumNumber) {
                    pickedWeights[0] = balancingWeights[j];
                    pickedWeights[1] = balancingWeights[i];
                    return pickedWeights;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner listReader = new Scanner(System.in);

        // Get First Weights
        String weightsInput = listReader.nextLine();

        if (weightsInput.split(" ").length != 2) {
            System.out.println("ERRO! A primeira lista tem de conter 2 pesos");
            System.exit(1);
        }

        int[] weightsList = new int[2];
        for (int i = 0; i < 2; i++) {
            int number = Integer.parseInt(weightsInput.split(" ")[i]);

            for (int j = 0; j < i; j++) {
                if (number == weightsList[j]) {
                    System.out.println("ERRO! Inseriu 2 numeros iguais");
                    System.exit(1);
                }
            }

            weightsList[i] = number;

        }

        // Get Second Weights
        weightsInput = listReader.nextLine();

        if (weightsInput.split(" ").length < 3) {
            System.out.println("ERRO! A segunda lista tem de conter pelo menos 3 pesos");
            System.exit(1);
        }

        int[] balancingWeights = new int[weightsInput.split(" ").length];
        for (int i = 0; i < weightsInput.split(" ").length; i++) {
            int number = Integer.parseInt(weightsInput.split(" ")[i]);

            balancingWeights[i] = number;
        }

        // Get Result

        int[] resultWeights = getEquilibrium(weightsList, balancingWeights);
        if (resultWeights == null) {
            System.out.println("Nao é possivel balancear");
        } else if (resultWeights[1] == -1) {
            System.out.printf("%d-lado direito\n", resultWeights[0]);
        } else if (resultWeights[0] == -1) {
            System.out.printf("%d-lado esquerdo\n", resultWeights[1]);
        } else if (resultWeights[0] + resultWeights[1] + weightsList[0] == weightsList[1]) {
            System.out.printf("%d-lado esquerdo,%d-lado esquerdo\n", resultWeights[0], resultWeights[1]);
        } else if (resultWeights[0] + resultWeights[1] + weightsList[1] == weightsList[0]) {
            System.out.printf("%d-lado direito,%d-lado direito\n", resultWeights[0], resultWeights[1]);
        } else {
            System.out.printf("%d-lado direito,%d-lado esquerdo\n", resultWeights[0], resultWeights[1]);
        }

        listReader.close();
    }
}