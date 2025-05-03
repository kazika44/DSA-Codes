package Array;

import java.util.HashSet;
import java.util.Set;

public class LongestSubSequence {
    static int findLongestConseqSubseq(int arr[], int N)
    {
        // add your code here
        Set<Integer> set = new HashSet<>();
        int ans=1,count=1;
        for(int i=0;i<N;i++){
            set.add(arr[i]);
        }
        for(int i=0;i<N;i++)
        {
            if(set.contains(arr[i]-1)){
                continue;
            }
            else{
                int y=arr[i];
                while(set.contains(y+1)){
                    count++;
                    y++;
                }
                ans=Math.max(ans,count);
                count=1;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        int arr[]={2,6,1,9,4,5,3};
        System.out.println(findLongestConseqSubseq(arr,arr.length));
    }
}
