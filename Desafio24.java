import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Desafio24{
    private static String convertToBinary(int number) {
        int remainder;

        if (number <= 1) {
            return number + "";
        }

        remainder = number % 2;
        return "" + convertToBinary(number >> 1) + remainder;
    }
    
    public static void main(String[] args){
        int N = -1;
        Scanner inputReader = new Scanner(System.in);
        do{
            N = Integer.parseInt(inputReader.nextLine());
        }while(N<2 || N>100000);

        String[] frequencies;
        do{
            frequencies = inputReader.nextLine().split(" ");
        }while(frequencies.length!=N);


        inputReader.close();

        Arrays.sort(frequencies,Collections.reverseOrder());


        //Get the closest power of 2 to the number of codes we need (round down) and get the ammout of codes we can build with that
        int closestPower = (int)Math.ceil(N/2);
        int numberOfCodes = (int)Math.pow(2, closestPower);

        ArrayList<String> binaryCodes = new ArrayList<>();
        
        //Build all the binary codes possible with the given power of 2
        for(int i = 0 ; i < numberOfCodes ; i++){ 
            binaryCodes.add(convertToBinary(i));
            while(binaryCodes.get(i).length() < closestPower){
                binaryCodes.set(i,"0" + binaryCodes.get(i));
            }
        }

        //In case we dont have enough codes we add another bit to get 2 more codes :D
        for(int i = 0 ; i < (N-numberOfCodes) ; i++){
            binaryCodes.set(i,"0" + binaryCodes.get(i));
            int len = binaryCodes.get(i).length();
            StringBuilder tempString = new StringBuilder();
            
            for(int j = 0 ; j < len-1 ; j++){
                tempString.append(binaryCodes.get(i).charAt(j));
            }
            tempString.append("1");

            binaryCodes.add(tempString.toString());
        }

        //Determine the costs of each binary code (0s = 1 ; 1s = 2)
        String[] costs = new String[N];
        for(int i = 0 ; i < N ; i++){
            int sum = 0;
            for(int j = 0 ; j <binaryCodes.get(i).length() ; j++){
                char tempChar = binaryCodes.get(i).charAt(j);
                if(tempChar == '0'){
                    sum+=1;
                }else{
                    sum+=2;
                }
            }
            costs[i] = sum+"";
        }

        //Sort the costs in ascending form (the lowest cost goes to the highest frequency, so we organize the arrays inverse to each other)
        Arrays.sort(costs);

        int totalCost = 0;
        for(int i = 0 ; i < N ; i++){
            totalCost+=(Integer.parseInt(frequencies[i])*Integer.parseInt(costs[i]));
        }

        System.out.println(totalCost);
    }
}