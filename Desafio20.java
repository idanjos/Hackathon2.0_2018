import java.util.Scanner;


public class Desafio20{

    public static int getArea(int[][] matrix){
        int[][] subSizeMatrix = new int[matrix.length][matrix.length];
        int biggest = 0;
        //Each element of the subSizeMatrix is gonna include the size of the submatrix of all 1's in which
        //the element in the matrix corresponds to the rightmost downmost element of the submatrix
        

        //From the way this algorithm works, we know the first column/row of the subSizeMatrix is gonna be the same as the normal matrix
        //since they dont have any elements behind/on top of them
        for(int i = 0; i < matrix.length; i++){
            subSizeMatrix[i][0] = matrix[i][0]; 
            subSizeMatrix[0][i] = matrix[0][i]; 
        }
              
        for(int i = 1; i < matrix.length; i++) { 
            for(int j = 1; j < matrix.length; j++){ 
                if(matrix[i][j] == 1){
                    //To build each element of the subSizeMAtrix we look at the element to it's left, above it and diagonal (left-up)
                    //We want the minimum of these since, if any of this is 0, then we dont have a submatrix of 1s
                    //We also add one since we know that at this element we have a 1, so worst case scenario we have a submatrix of size 0+1 (= 1 = the element itself)
                    subSizeMatrix[i][j] = Math.min(subSizeMatrix[i][j-1], Math.min(subSizeMatrix[i-1][j], subSizeMatrix[i-1][j-1])) + 1; 
                    
                    if(biggest<subSizeMatrix[i][j])
                        biggest = subSizeMatrix[i][j];
                }else
                    subSizeMatrix[i][j] = 0; 
            }  
        } 
        
        
        return biggest*biggest;
    }

    public static void main(String[] args){
        Scanner inputReader = new Scanner(System.in);

        String input = inputReader.nextLine();

        input = input.replaceAll("[\"\\s]", "");
        input = input.replace("]","");
        input = input.replace("[","");


        String[] matrix = input.split(",");

        int[][] trueMatrix = new int[matrix.length][matrix.length];

        for(int i = 0 ; i < matrix.length ; i++){
            //System.out.println(matrix[i]);
            for(int j = 0 ; j<matrix.length ; j++){
                trueMatrix[i][j] = Character.getNumericValue(matrix[i].charAt(j));
            }
        }

        System.out.println(getArea(trueMatrix));

        inputReader.close();
    }
}