package Array;

import java.util.Arrays;

public class MedianofArray {
    public static int median(int arr[]){
        Arrays.sort(arr);
        if((arr.length)%2!=0)
            return arr[arr.length/2];
        return (arr[(arr.length/2)-1]+arr[(arr.length/2)])/2;
    }
}
