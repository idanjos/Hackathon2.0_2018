import java.util.Scanner;
import java.util.ArrayList;


public class Desafio23{


    public static ArrayList<int[]> getBadPairs(int numberOfNodes,ArrayList<int[]> connections){
        ArrayList<int[]> badPairs = new ArrayList<>();

        //Go through all connections and check wich ones need changing
        for(int i= 0 ; i < numberOfNodes-1 ; i++){
            if(connections.get(i)[2] != connections.get(i)[3] && connections.get(i)[3] != 2){
                int[] tempArray = {connections.get(i)[0],connections.get(i)[1]};
                badPairs.add(tempArray);
            }
        }

        return badPairs;
    }

    public static ArrayList<Integer> getPaths(int numberOfNodes,ArrayList<int[]> connections,int[] currentPair){
        String pathAsString = currentPair[0] + " " + currentPair[1]+ " ";

        //Find all paths that include that pair
        for(int i= 0 ; i < numberOfNodes-1 ; i++){
            if(connections.get(i)[0] == currentPair[1]){
                pathAsString = pathAsString + connections.get(i)[1] + " ";
            }else if(connections.get(i)[1] == currentPair[0]){
                pathAsString = pathAsString + connections.get(i)[0] + " ";
            }
        }

        String[] pathAsStringArray = pathAsString.split(" ");
        ArrayList<Integer> path = new ArrayList<>();
        for(int i = 0 ; i < pathAsStringArray.length; i++){
            path.add(Integer.parseInt(pathAsStringArray[i]));
        }

        return path;
    }
    public static void main(String[] args){
        Scanner inputReader = new Scanner(System.in);
        int numberOfNodes = 0;

        while(numberOfNodes<2 || numberOfNodes>(10*10*10*10*10))
            numberOfNodes = Integer.parseInt(inputReader.nextLine());

        ArrayList<int[]> connections = new ArrayList<>();

        for(int i = 0 ; i < numberOfNodes-1 ; i++){
            String[] tempString = inputReader.nextLine().split(" ");
            int[] tempArray = new int[4];
            tempArray[0] = Integer.parseInt(tempString[0]);
            tempArray[1] =  Integer.parseInt(tempString[1]);
            tempArray[2] =  Integer.parseInt(tempString[2]);
            tempArray[3] =  Integer.parseInt(tempString[3]);
            connections.add(tempArray);
        }

        inputReader.close();

        int[] result = {0,0};
        
        ArrayList<int[]> badPairs = getBadPairs(numberOfNodes, connections);


        //If we have no bad pairs then groovy! We're done here :D
        if(badPairs.size()==0){
            System.out.printf("\n%d %d\n",result[0],result[1]);
        }

        //Array with all paths (possibly) needed
        ArrayList<ArrayList<Integer>> conjoinedPaths = new ArrayList<>();

        for(int i = 0 ; i < badPairs.size() ; i++){
            ArrayList<Integer> newPath = getPaths(numberOfNodes, connections, badPairs.get(i));
            conjoinedPaths.add(newPath);
        }

        ArrayList<ArrayList<Integer>> takenPaths = new ArrayList<>();

        //Go through all bad pairs
        for(int i = 0 ; i < badPairs.size() ; i++){
            int num1 = badPairs.get(i)[0];
            int num2 = badPairs.get(i)[1];
            ArrayList<ArrayList<Integer>> possiblePaths = new ArrayList<>();

            boolean alreadyFoundFlag = false;

            //Check if we already had a path passing through these nodes taken into consideration
            for(int j = 0 ; j<takenPaths.size() ; j++){
                if(takenPaths.get(j).contains(num1) && takenPaths.get(j).contains(num2)){
                    alreadyFoundFlag = true;
                }
            }

            if(alreadyFoundFlag){
                continue;
            }

            //Else, check our paths array to see which paths contain the numbers and put them in a possible paths array
            for(int j = i ; j<conjoinedPaths.size();j++){
                if(conjoinedPaths.get(j).contains(num1) && conjoinedPaths.get(j).contains(num2)){
                    possiblePaths.add(conjoinedPaths.get(j));
                }
            }

            result[0] = result[0] + 1;

            //Get the minimum of these paths
            int min = possiblePaths.get(0).size() ;
            int pos = 0;
            for (int j = 1 ; j<possiblePaths.size();j++){
                if(min>possiblePaths.get(j).size()){
                    min = possiblePaths.get(j).size();
                    pos = j;
                }
            }
            
            //Add the cost (the size of the smallest path containing the nodes - 1)
            result[1] = result[1] + min - 1;
            takenPaths.add(possiblePaths.get(pos));
        }

        System.out.printf("\n%d %d\n",result[0],result[1]);
        
    }
}