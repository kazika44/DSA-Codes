package Coding.Array;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraySum {
    public static int countSubarraySum(int[] arr, int k) {
        int prefixSum=0,count=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int num:arr){
            prefixSum+=num;
            if(map.containsKey(prefixSum-k)){
                count+=map.get(prefixSum-k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int k = 3;
        System.out.println("Number of subarrays with sum " + k + ": " + countSubarraySum(arr, k));
    }
}
