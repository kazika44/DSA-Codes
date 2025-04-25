package Array;

import java.util.*;

public class RemoveDuplicate {
    //Bruteforce appraoch
    public static void removeDuplicate(int arr[]){git
        Set<Integer> unique= new HashSet<>();
        for(int i=0;i<arr.length;i++){
            unique.add(arr[i]);
        }
        System.out.println(unique.size());
        int j=0;
        for(Integer i:unique){
            arr[j]=i;
            j++;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String args[]){
        removeDuplicate(new int[]{1, 1, 2, 2, 2, 3, 3, 3});
    }
}
