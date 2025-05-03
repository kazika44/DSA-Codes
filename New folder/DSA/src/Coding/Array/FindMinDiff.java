package Coding.Array;

import java.util.ArrayList;
import java.util.Collections;

public class FindMinDiff {
    public long findMinDiff (ArrayList<Integer> arr, int n, int m)
    {
        // your code here
        if(n<m)
            return -1;
        int start=0;
        int end=m-1;
        long min=Integer.MAX_VALUE;
        Collections.sort(arr);
        while(end<n){
            min= Math.min(min,arr.get(end)-arr.get(start));
        }
        return min;
    }
}
