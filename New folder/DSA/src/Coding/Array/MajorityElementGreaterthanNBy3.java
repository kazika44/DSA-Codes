package Coding.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementGreaterthanNBy3 {
    public List<Integer> majorityElementBetterSolutionUsingHashing(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (!list.contains(nums[i]) && map.get(nums[i]) > nums.length / 3) list.add(nums[i]);
        }
        return list;
    }

    public List<Integer> majorityElementOptimalSolutionUsingMooresVotingAlgo(int[] nums) {
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 0;

        for (int num : nums) {
            if (count1 == 0 && num != candidate2) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0 && num != candidate1) {
                candidate2 = num;
                count2 = 1;
            } else if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // Verify the candidates
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            if (num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;
        if (count1 > threshold) result.add(candidate1);
        if (count2 > threshold && candidate2 != candidate1) result.add(candidate2);

        return result;
    }

    public static void main(String[] args) {
        MajorityElementGreaterthanNBy3 solution = new MajorityElementGreaterthanNBy3();

        // Test case 1
        int[] nums1 = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println("Test case 1:");
        System.out.println("Using Hashing: " + solution.majorityElementBetterSolutionUsingHashing(nums1));
        System.out.println("Using Moore's Voting: " + solution.majorityElementOptimalSolutionUsingMooresVotingAlgo(nums1));

        // Test case 2
        int[] nums2 = {1, 2, 2, 3, 2, 1, 1, 3};
        System.out.println("\nTest case 2:");
        System.out.println("Using Hashing: " + solution.majorityElementBetterSolutionUsingHashing(nums2));
        System.out.println("Using Moore's Voting: " + solution.majorityElementOptimalSolutionUsingMooresVotingAlgo(nums2));
    }

}
