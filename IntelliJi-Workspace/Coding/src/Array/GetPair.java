package Array;

import java.util.HashMap;
import java.util.Map;

public class GetPair {
    int getPairsCount(int[] arr, int sum) {
        // code here
        int result=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(sum-arr[i])){
                result+=map.get(sum-arr[i]);
            }
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        return result;
    }
}
