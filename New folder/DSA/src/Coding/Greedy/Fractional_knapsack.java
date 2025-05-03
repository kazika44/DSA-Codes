package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fractional_knapsack {
    class Items{
        int weight;
        int value;
    }
    public static void fractionalknapsack(int w,Items arr[],int n){
        Arrays.sort(arr,(a,b)->{
                double a1=(double) a.value/a.weight;
            double b1=(double) b.value/b.weight;
            if(a1<b1)
                return 1;
            else if(a1>b1)
                return -1;
            else
                return 0;
        });
        double resultValue=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].weight<w)
            {
                resultValue+=arr[i].value;
                w-=arr[i].weight;
            }
            else {
                resultValue=(double) arr[i].value/arr[i].weight*w;
            }
        }

    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        List<int[]> boxes = new ArrayList<>();
        for(int i=0;i<boxTypes.length;i++){
            boxes.add(boxTypes[i]);
        }
        boxes.sort((a,b)->{
            return b[1]-a[1];
        });
        int result=0;
        for(int i=0;i< boxes.size();i++){
            int curr[]=boxes.get(i);
            if(curr[0]<=truckSize)
            {
                result+=curr[0]*curr[1];
                truckSize-=curr[0];
            }
            else{
                result+=truckSize*curr[1];
            }
        }
        return result;

    }
}
