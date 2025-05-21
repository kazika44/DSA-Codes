package Coding.Array;

import java.util.Arrays;

public class MergeTwoSortedArray {
    // Brute force approach
    public void mergeTwoSortedArray(int[] arr1,int[] arr2){
        int i=0,j=0,index=0;
        int n = arr1.length;
        int m = arr2.length;
        int[] arr3 = new int[n+m];
        while(i<n && j<m){
            if(arr1[i]<arr2[j]){
                arr3[index++]=arr1[i++];
            }
            else{
                arr3[index++]=arr2[j++];
            }
        }
        while(i< n){
            arr3[index++]=arr1[i++];
        }
        while(j<m){
            arr3[index++]=arr2[j++];
        }
        for(i=0;i<n+m;i++){
            if(i<n){
                arr1[i] = arr3[i];
            }
            else{
                arr2[i-n] = arr3[i];
            }
        }
        System.out.println("Sorted array is:"+ Arrays.toString(arr1) + Arrays.toString(arr2));
    }

    //OPTIMAL SOLUTION

    public void mergeTwoSortedArrayOptimized(int[] arr1,int[] arr2){
        int n =arr1.length;
        int m = arr2.length;
        int left = n-1;
        int right = 0;
        while(left>=0 && right<m){
            if(arr1[left] > arr2[right]){
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            }
            else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println("Sorted array is:"+ Arrays.toString(arr1) + Arrays.toString(arr2));
    }

    public static void main(String[] args){
        int[] arr1 = {1,4,8,10,11};
        int[] arr2 = {2,3,9};
        MergeTwoSortedArray solution = new MergeTwoSortedArray();
//        solution.mergeTwoSortedArray(arr1,arr2);

        //Optimal Solution Calling mergeTwoSortedArrayOptimized()

        solution.mergeTwoSortedArrayOptimized(arr1,arr2);
    }
}
