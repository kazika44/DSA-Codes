package Array;

public class ThreeWayPartition {
    public void threeWayPartition(int arr[],int a, int b){
        int n=arr.length;
        int start=0;
        int end=n-1;
        for(int i=0;i<n;i++){
            if(i>end)
                break;
            if(arr[i]<a)
            {
                int temp=arr[i];
                arr[i]=arr[start];
                arr[start]=temp;
                start++;
            }
            else if(arr[i]>b){
                int temp=arr[i];
                arr[i]=arr[end];
                arr[end]=temp;
                end--;
            }
        }
    }
}
