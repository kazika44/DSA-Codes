package Array;

public class MinimumSwap {
    public int minSwaps(int arr[],int k){
        int counter=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=k){
                counter++;
            }
        }
        int undesirable=0;
        for(int i=0;i<counter;i++){
            if(arr[i]>k){
                undesirable++;
            }
        }
        int min=undesirable;
        for(int i=counter;i<arr.length;i++){
            if(arr[i]>k){
                undesirable++;
            }
            if(arr[i-counter]>k){
                undesirable--;
            }
            min=Math.min(min,undesirable);
        }
        return min;
    }
}
