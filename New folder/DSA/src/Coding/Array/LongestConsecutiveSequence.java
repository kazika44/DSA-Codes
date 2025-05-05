package Coding.Array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
        public int longestConsecutive(int[] nums) {
            if(nums.length == 0){
                return 0;
            }
            int maxValue = 0;
            int n = nums.length;
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num);
            }
            for(int num : set){
                if(!set.contains(num - 1)){
                    int currentNum = num;
                    int currentStreak = 1;
                    while(set.contains(num + 1)){
                        currentNum++;
                        currentStreak++;
                    }
                    maxValue = Math.max(maxValue,currentStreak);
                }
            }
            return maxValue;
        }

}
