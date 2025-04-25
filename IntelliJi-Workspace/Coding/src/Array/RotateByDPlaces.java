package Array;

import java.util.Arrays;
import java.util.Collections;

public class RotateByDPlaces {
    public static void rotateByDPlaces(int arr[], int d) {
        int n = arr.length;
        d=d%n;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
        System.out.println("Modified Array after "+d+" rotation:"+"\n"+Arrays.toString(arr));

    }

    public static void reverse(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String args[]) {
        int arr[]={1,2,3,4,5,6,7};

        System.out.println("Original array:"+"\n"+Arrays.toString(arr));
        rotateByDPlaces(arr, 10);

    }

}
