package Array;

public class RearrangeArrayElementBySign {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        int posind=0,negind=1;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                res[negind]=nums[i];
                negind+=2;
            }
            else{
                res[posind]=nums[i];
                posind+=2;
            }
        }
        return res;
    }
}
