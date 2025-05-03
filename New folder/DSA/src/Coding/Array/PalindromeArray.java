package Array;

public class PalindromeArray {
    public static boolean palindromeArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            String val=Integer.toString(arr[i]);
            String rev= new StringBuilder(val).reverse().toString();
            if(!rev.equals(val))
                return false;
        }
        return true;
    }
    public static void main(String args[]){
        int arr[]={111,222,333,444};
        System.out.println(palindromeArray(arr));
    }
}
