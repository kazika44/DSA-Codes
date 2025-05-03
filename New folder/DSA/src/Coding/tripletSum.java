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
        return outerList;
    }
}
