package Greedy;

import java.util.Arrays;

public class LongestChain {
    public static int longestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int chain = 0;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < pairs.length; i++) {
            if(pairs[i][0]>prev){
                chain++;
                prev=pairs[i][1];
            }
        }
        return chain;
    }
}
