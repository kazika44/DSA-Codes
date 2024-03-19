package backtracking;

public class Compute {
	    
	    public long[] getTriangle(long arr[], long n)
	    {
	    	long[] temp=new long[arr.length-1];
	        if(n==0)
	        	return temp;
	        long[] ans;
	        temp=helper(arr,n,0,temp);
	        temp=arr;
	        return getTriangle(arr,arr.length);
	        
	    }
	    public long[] helper(long[] arr, long n ,int index,long[] temp)
	    {
	        if(index==arr.length-1)
	            return temp;
	            
	        temp[index]=arr[index]+arr[index+1];
	        helper(arr,n,index+1,temp);
	        return temp;
	    }
	}

