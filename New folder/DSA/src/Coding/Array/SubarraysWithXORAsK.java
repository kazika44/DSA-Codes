package Coding.Array;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithXORAsK {
    public long subarrayXor(int arr[], int k) {
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        int prefixxor = 0;
        int count = 0;
        map.put(prefixxor,1);
        for(int i=0;i<arr.length;i++){
            prefixxor = prefixxor ^ arr[i];
            int xorneeded = prefixxor ^ k;
            if(map.containsKey(xorneeded)){
                count += map.get(xorneeded);
            }
            map.put(prefixxor,map.getOrDefault(prefixxor,0)+1);
        }

        return count;

    }

    public static void main(String[] args) {
        SubarraysWithXORAsK solution = new SubarraysWithXORAsK();

        // Test case 1
        int[] arr1 = {4, 2, 2, 6, 4};
        int k1 = 6;
        System.out.println("Test case 1:");
        System.out.println("Number of subarrays with XOR " + k1 + ": " + solution.subarrayXor(arr1, k1));

        // Test case 2
        int[] arr2 = {5, 6, 7, 8, 9};
        int k2 = 5;
        System.out.println("\nTest case 2:");
        System.out.println("Number of subarrays with XOR " + k2 + ": " + solution.subarrayXor(arr2, k2));
    }

}
