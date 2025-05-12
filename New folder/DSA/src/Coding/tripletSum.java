package Coding;
import java.util.*;
public class tripletSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outerList = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length<3)
            return outerList;
        if(nums[0]>0)
            return outerList;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                int required = -nums[i]-nums[j];
                if(map.containsKey(required) && map.get(required)>j){
                    outerList.add(Arrays.asList(nums[i],nums[j],required));
                }
                j=map.get(nums[j]);
            }
            i=map.get(nums[i]);
        }
        return outerList;
    }

    private static void printTriplets(List<List<Integer>> triplets) {
        if (triplets.isEmpty()) {
            System.out.println("No triplets found!");
            return;
        }
        System.out.println("Found triplets:");
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
    }

    public static void main(String[] args) {
        tripletSum solution = new tripletSum();

        // Test case 1: Basic case with multiple solutions
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("\nTest case 1:");
        printTriplets(solution.threeSum(nums1));

        // Test case 2: All zeros
        int[] nums2 = {0, 0, 0, 0};
        System.out.println("\nTest case 2:");
        printTriplets(solution.threeSum(nums2));

        // Test case 3: No solution
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println("\nTest case 3:");
        printTriplets(solution.threeSum(nums3));
    }
}
