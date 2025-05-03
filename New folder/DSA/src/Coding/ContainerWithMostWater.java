package Coding;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        return helper(height,0);
    }
    public int helper(int [] height, int maxArea)
    {
        int start=0;
        int end=height.length-1;
        while(start<end)
        {
            int min=Math.min(height[start],height[end]);
            maxArea=Math.max(maxArea,min*(end-start));
            while (height[start] <= min && start < end) {
                start++;
            }
            while (height[end] <= min && start < end) {
                end--;
            }
        }
        return maxArea;

    }

}
