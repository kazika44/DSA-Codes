package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CandyStore {
    static ArrayList<Integer> candyStore(int candies[], int N, int K) {
        // code here
        int min = 0;
        int max=0;
        Arrays.sort(candies);
        min=candyStoreHelper(candies, N, K, min);
        System.out.println(min);
        Integer[] numbersArray = Arrays.stream(candies).boxed().toArray(Integer[]::new);
        Arrays.sort(numbersArray, (a, b) -> b.compareTo(a));
        int[] sortedNumbers = Arrays.stream(numbersArray).mapToInt(Integer::intValue).toArray();
        max=candyStoreHelper(sortedNumbers, N, K, max);

        return new ArrayList<>(Arrays.asList(min, max));
    }
    static int candyStoreHelper(int candies[], int N, int K, int minmax) {
        int varLength=N;
        for(int i=0;i<varLength;i++){
            if(varLength>0)
            {
                minmax+=candies[i];
                varLength-=K;
            }
        }
        return minmax;
    }
    public static void main(String args[]){
        int arr[]=new int[]{3,2,1,4};
        System.out.println(candyStore(arr,arr.length,2));

    }
}
