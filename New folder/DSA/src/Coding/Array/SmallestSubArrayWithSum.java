package Array;

public class SmallestSubArrayWithSum {
    public int smallestSubArrayWithSum(int []arr,int x){
        int min=Integer.MAX_VALUE;
        int n=arr.length;
        int sum=0;
        int j=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            while(sum>x){
                sum-=arr[j];
                min=Math.min(min,i-j+1);
                j++;
            }
        }
        if(min==Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}
