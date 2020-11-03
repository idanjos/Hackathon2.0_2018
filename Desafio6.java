import java.util.Scanner;


public class Desafio6{

    public static boolean solveMove(int[][] grid,String[] moves){

        //Check if we still have positions left to move && we're at the desired position
        boolean solvedFlag = true;

        int unsolvedIndex = -1;

        for(int i = 0 ; i<moves.length ; i++){
            if(moves[i].equals("?")){
                unsolvedIndex = i;
                solvedFlag = false;
                break;
            }
        }

        if(solvedFlag && grid[3][3] == 1){
            return true;
        }

        //If we haven't solved the grid and have no more moves left we need to backtrack!
        if(unsolvedIndex==-1){
            return false;
        }

        int[] currentPos = {0,0};
        //find our current position on the grid
        for(int i = 0 ; i<grid.length ; i++){
            for(int j = 0 ; j<grid.length ; j++){
                if(grid[i][j] == 1){
                    currentPos[0] = i;
                    currentPos[1] = j;
                }
            }
        }
        //Try to fill the unfilled position with movement
        for(int i = 0 ; i <= 3 ; i++){
            int nextX = currentPos[0];
            int nextY = currentPos[1];
            switch(i){
                case 0: //up                    
                    if(nextX-1>0){
                        grid[nextX][nextY] = 0;
                        grid[--nextX][nextY] = 1;

                        //Move the next moves in the moveset
                        boolean invalidMoveFlag = false;
                        for(int k = unsolvedIndex+1 ; k<moves.length ; k++){
                            if(moves[k].equals("?"))
                                break;
                            
                            if(moves[k].equals("c")){
                                if(nextX-1>0){
                                    grid[nextX][nextY] = 0;
                                    grid[--nextX][nextY] = 1;
                                }else{
                                    invalidMoveFlag = true;
                                    break;
                                }
                                
                            }
                            if(moves[k].equals("b")){
                                if(nextX+1<grid.length){
                                    grid[nextX][nextY] = 0;
                                    grid[++nextX][nextY] = 1;
                                }else{
                                    invalidMoveFlag = true;
                                    break;
                                }
                            }
                            if(moves[k].equals("e")){
                                if(nextY-1>0){
                                    grid[nextX][nextY] = 0;
                                    grid[nextX][--nextY] = 1;
                                }else{
                                    invalidMoveFlag = true;
                                    break;
                                }
                            }
                            if(moves[k].equals("d")){
                                if(nextY+1<grid.length){
                                    grid[nextX][nextY] = 0;
                                    grid[nextX][++nextY] = 1;
                                }else{
                                    invalidMoveFlag = true;
                                    break;
                                }
                            }
                        }

                        if(invalidMoveFlag){
                            grid[currentPos[0]][currentPos[1]] = 1;
                            grid[nextX][nextY] = 0;
                            break;
                        }

                        moves[unsolvedIndex] = "c";


                        //Move forward with recursion
                        if(solveMove(grid,moves)){
                            return true;
                        }

                        //If moving forward returns false it means we had to backtrack so this number isnt correct :( (try another)
                        grid[currentPos[0]][currentPos[1]] = 1;
                        grid[nextX][nextY] = 0;
                        

                        moves[unsolvedIndex] = "?";
                    }
                    break;
                case 1: //down
                    if(nextX+1<grid.length){
                        grid[nextX][nextY] = 0;
                        grid[++nextX][nextY] = 1;
                        
                        //Move the next moves in the moveset
                        boolean invalidMoveFlag = false;
                        for(int k = unsolvedIndex+1 ; k<moves.length ; k++){
                            if(moves[k].equals("?"))
                                break;
                            
                            if(moves[k].equals("c")){
                                if(nextX-1>0){
                                    grid[nextX][nextY] = 0;
                                    grid[--nextX][nextY] = 1;
                                }else{
                                    invalidMoveFlag = true;
                                    break;
                                }
                                
                            }
                            if(moves[k].equals("b")){
                                if(nextX+1<grid.length){
                                    grid[nextX][nextY] = 0;
                                    grid[++nextX][nextY] = 1;
                                }else{
                                    invalidMoveFlag = true;
                                    break;
                                }
                            }
                            if(moves[k].equals("e")){
                                if(nextY-1>0){
                                    grid[nextX][nextY] = 0;
                                    grid[nextX][--nextY] = 1;
                                }else{
                                    invalidMoveFlag = true;
                                    break;
                                }
                            }
                            if(moves[k].equals("d")){
                                if(nextY+1<grid.length){
                                    grid[nextX][nextY] = 0;
                                    grid[nextX][++nextY] = 1;
                                }else{
                                    invalidMoveFlag = true;
                                    break;
                                }
                            }
                        }

                        if(invalidMoveFlag){
                            grid[currentPos[0]][currentPos[1]] = 1;
                            grid[nextX][nextY] = 0;
                            break;
                        }

                        moves[unsolvedIndex] = "b";
                        

                        //Move forward with recursion
                        if(solveMove(grid,moves)){
                            return true;
                        }

                        //If moving forward returns false it means we had to backtrack so this number isnt correct :( (try another)
                        grid[currentPos[0]][currentPos[1]] = 1;
                        grid[nextX][nextY] = 0;

                        moves[unsolvedIndex] = "?";
                    }

                    break;
                case 2: //left
                    if(nextY-1>0){
                        grid[nextX][nextY] = 0;
                        grid[nextX][--nextY] = 1;
                        
                        //Move the next moves in the moveset
                        boolean invalidMoveFlag = false;
                        for(int k = unsolvedIndex+1 ; k<moves.length ; k++){
                            if(moves[k].equals("?"))
                                break;
                            
                            if(moves[k].equals("c")){
                                if(nextX-1>0){
                                    grid[nextX][nextY] = 0;
                                    grid[--nextX][nextY] = 1;
                                }else{
                                    invalidMoveFlag = true;
                                    break;
                                }
                                
                            }
                            if(moves[k].equals("b")){
                                if(nextX+1<grid.length){
                                    grid[nextX][nextY] = 0;
                                    grid[++nextX][nextY] = 1;
                                }else{
                                    invalidMoveFlag = true;
                                    break;
                                }
                            }
                            if(moves[k].equals("e")){
                                if(nextY-1>0){
                                    grid[nextX][nextY] = 0;
                                    grid[nextX][--nextY] = 1;
                                }else{
                                    invalidMoveFlag = true;
                                    break;
                                }
                            }
                            if(moves[k].equals("d")){
                                if(nextY+1<grid.length){
                                    grid[nextX][nextY] = 0;
                                    grid[nextX][++nextY] = 1;
                                }else{
                                    invalidMoveFlag = true;
                                    break;
                                }
                            }
                        }

                        if(invalidMoveFlag){
                            grid[currentPos[0]][currentPos[1]] = 1;
                            grid[nextX][nextY] = 0;
                            break;
                        }

                        moves[unsolvedIndex] = "e";

                

                        //Move forward with recursion
                        if(solveMove(grid,moves)){
                            return true;
                        }

                        //If moving forward returns false it means we had to backtrack so this number isnt correct :( (try another)
                        grid[currentPos[0]][currentPos[1]] = 1;
                        grid[nextX][nextY] = 0;

                        moves[unsolvedIndex] = "?";
                    }

                    break;
                case 3: //right
                    if(nextY+1<grid.length){
                        grid[nextX][nextY] = 0;
                        grid[nextX][++nextY] = 1;
                        
                        //Move the next moves in the moveset
                        boolean invalidMoveFlag = false;
                        for(int k = unsolvedIndex+1 ; k<moves.length ; k++){
                            if(moves[k].equals("?"))
                                break;
                            
                            if(moves[k].equals("c")){
                                if(nextX-1>0){
                                    grid[nextX][nextY] = 0;
                                    grid[--nextX][nextY] = 1;
                                }else{
                                    invalidMoveFlag = true;
                                    break;
                                }
                                
                            }
                            if(moves[k].equals("b")){
                                if(nextX+1<grid.length){
                                    grid[nextX][nextY] = 0;
                                    grid[++nextX][nextY] = 1;
                                }else{
                                    invalidMoveFlag = true;
                                    break;
                                }
                            }
                            if(moves[k].equals("e")){
                                if(nextY-1>0){
                                    grid[nextX][nextY] = 0;
                                    grid[nextX][--nextY] = 1;
                                }else{
                                    invalidMoveFlag = true;
                                    break;
                                }
                            }
                            if(moves[k].equals("d")){
                                if(nextY+1<grid.length){
                                    grid[nextX][nextY] = 0;
                                    grid[nextX][++nextY] = 1;
                                }else{
                                    invalidMoveFlag = true;
                                    break;
                                }
                            }
                        }

                        if(invalidMoveFlag){
                            grid[currentPos[0]][currentPos[1]] = 1;
                            grid[nextX][nextY] = 0;
                            break;
                        }
    
                        moves[unsolvedIndex] = "d";
                        
                      

                        //Move forward with recursion
                        if(solveMove(grid,moves)){
                            return true;
                        }
    
                        //If moving forward returns false it means we had to backtrack so this number isnt correct :( (try another)
                        grid[currentPos[0]][currentPos[1]] = 1;
                        grid[nextX][nextY] = 0;
    
                        moves[unsolvedIndex] = "?";
                    }

                    break;
            }
        }

        //We reach this only if theres no possible configuration of the sudoku in its current state
        return false;
    }

    public static void main(String[] args){
        Scanner inputReader = new Scanner(System.in);

        int[][] grid = new int[4][4];
        for(int i = 0 ; i<grid.length ; i++){
            for(int j = 0 ; j<grid.length ; j++){
                grid[i][j] = 0;
            }
        }

        grid[0][0] = 1;

        String[] line;
        do{
            line = inputReader.nextLine().split("");

            int counter = 0;
            for(int i = 0 ; i<line.length ; i++){
                if(line[i].equals("?")){
                    counter++;
                }
                if(counter>=2)
                    break;
            }

            if(counter>=2)
                break;

        }while(true);
    
        System.out.println();
        if(solveMove(grid,line)){
            for(int i = 0 ; i < line.length ; i++){
                System.out.printf("%s",line[i]);
            }
            System.out.println();
        }else
            System.out.println("Nao foi encontrada nenhuma solucao");

        inputReader.close();
    }
}