import java.util.Scanner;


public class Desafio18{
    public static boolean checkSafety(int[][] matrix, int row, int col, int num){
        //Check if number has been used in row or col
        for(int i = 0 ; i<9 ; i++){
            if(i != col && matrix[row][i] == num){
                return false;
            }

            if(i != row && matrix[i][col] == num){
                return false;
            }
        }

        //Check if number has been used in square
        for (int i = 0; i < 3; i++)
		    for (int j = 0; j < 3; j++)
			    if (matrix[i + (row - row % 3)][j + (col - col % 3)] == num)
				    return false;

        return true;
    }

    public static boolean solveSudoku(int[][] sudoku){

        //Check if matrix is solved
        boolean solvedFlag = true;
        int unsolvedRow = -1;
        int unsolvedCol = -1;
        for(int i = 0 ; i<9 ; i++){
            for(int j = 0 ; j<9 ; j++){
                if(sudoku[i][j] == 0){
                    solvedFlag = false;
                    unsolvedRow = i;
                    unsolvedCol = j;
                }
            }
        }

        if(solvedFlag){
            return true;
        }

        //Try to fill the unfilled position with digits from 1 to 9
        for(int i = 1 ; i <= 9 ; i++){

            //Check safety of adding current number
            if(checkSafety(sudoku, unsolvedRow, unsolvedCol, i)){
                sudoku[unsolvedRow][unsolvedCol] = i;

                //Move forward with recursion
                if(solveSudoku(sudoku)){
                    return true;
                }

                //If moving forward returns false it means we had to backtrack so this number isnt correct :( (try another)
                sudoku[unsolvedRow][unsolvedCol] = 0;
            }  
        }

        //We reach this only if theres no possible configuration of the sudoku in its current state
        return false;
    }

    public static void main(String[] args){
        Scanner inputReader = new Scanner(System.in);

        int[][] sudoku = new int[9][9];

        String[] line;

        for(int i = 0 ; i<9 ; i++){
            do{
                line = inputReader.nextLine().split(" ");
            }while(line.length!=9);

            for(int j = 0 ; j < 9 ; j++){
                sudoku[i][j] = Integer.parseInt(line[j]);
                //System.out.println(sudoku[i][j]);
            }
        }

        System.out.println();
        if(solveSudoku(sudoku))
            for(int i = 0 ; i < 9 ; i++){
                for(int j = 0 ; j < 9 ; j++)
                    System.out.printf("%d ",sudoku[i][j]);
                System.out.println();
            }
        else
            System.out.println("Nao foi encontrada nenhuma solucao");

        inputReader.close();
    }
}