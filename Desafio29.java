import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;


public class Desafio29{

    public static ArrayList<Integer> generatePrimes(int N){
        ArrayList<Integer> primes = new ArrayList<>();

        int count = 0;
        int i;
        for(int num=1; count<N; num++)
        {
            for(i=2; num%i != 0; i++);
            if(i == num){
                primes.add(num);
                count++;
            }
        }
        return primes;
    }

    public static void main(String[] args){

        Scanner inputReader = new Scanner(System.in);
        int N = -1;
        do{
            System.out.println("Insira o numero de Cilindros");
            N = Integer.parseInt(inputReader.nextLine());
        }while(N<-1 || N>200);

        int P = -1;
        do{
            System.out.println("Insira o numero de Stacks");
            P = Integer.parseInt(inputReader.nextLine());
        }while(P<-1 || P>30);

        inputReader.close();

        //ArrayList<Integer> primes = generatePrimes(N);
        int[] allPrimeNumbers = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,271,277,281,283,293,307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,503,509,521,523,541,547,557,563,569,571,577,587,593,599,601,607,613,617,619,631,641,643,647,653,659,661,673,677,683,691,701,709,719,727,733,739,743,751,757,761,769,773,787,797,809,811,821,823,827,829,839,853,857,859,863,877,881,883,887,907,911,919,929,937,941,947,953,967,971,977,983,991,997,1009,1013,1019,1021,1031,1033,1039,1049,1051,1061,1063,1069,1087,1091,1093,1097,1103,1109,1117,1123,1129,1151,1153,1163,1171,1181,1187,1193,1201,1213,1217,1223};

        ArrayList<Integer> primes = new ArrayList<>();
        //Get the N first prime numbers
        for(int i = (N-1) ; i>-1 ; i--){
            primes.add(allPrimeNumbers[i]);
        }
        ArrayList<ArrayList<Integer>> stacks = new ArrayList<>();

        //Calculate the best possible number
        int desired = 0;
        for(int i = 0 ; i < N ; i++){
            desired+=primes.get(i);
        }
    
        desired = (int) Math.ceil(desired/P);

        //For each stack we start by first adding the numbers from the top of our list until the sum of the stack is NOT over the desired number
        //Then, when we reach the last stack we start adding the remaining numbers to the stack whose sum is the current lowest :)
        for(int i = 0 ; i < P ; i++){
            int sum = 0;

            stacks.add(new ArrayList<>());
            if(i==(P-1)){
                while(primes.size()!=0){
                    int minStackSum = 0;
                    int minStackIndex = 0;

                    //Get Lowest Sum Stack
                    for(int j = 0 ; j<stacks.get(0).size() ; j++){
                        minStackSum+= stacks.get(0).get(j);
                    }

                    for(int stack = 1 ; stack<P ; stack++){
                        int tempSum = 0;
                        for(int j = 0 ; j<stacks.get(stack).size() ; j++){
                            tempSum+= stacks.get(stack).get(j);
                        }
                        if(tempSum<minStackSum){
                            minStackSum = tempSum;
                            minStackIndex = stack;
                        }
                    }

                    //Add the next number
                    stacks.get(minStackIndex).add(primes.get(0));
                    primes.remove(0);
                }
                break;
            }
            while(true){
                sum+=primes.get(0);
                //Check if adding the next number would make the sum of the stack overflow over the desired number
                if(sum>desired)
                    break;
                stacks.get(i).add(primes.get(0));
                primes.remove(0);
            }
        }

        for(int i = 0 ; i<P ; i++){
            StringBuilder tempString = new StringBuilder();
            int sum = 0;
            for(int j = 0 ; j<stacks.get(i).size() ; j++){
                sum+= stacks.get(i).get(j);
                tempString.append(" ");
                tempString.append(stacks.get(i).get(j));
            }

            System.out.printf("pilha %d (%d): %s\n",i+1,sum,tempString.toString());
        }
    }
}