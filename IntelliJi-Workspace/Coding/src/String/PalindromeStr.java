package String;

public class PalindromeStr {
    public static boolean palindrome(String s){
        int start = 0;
        int end=s.length()-1;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
        }
        return true;
    }
}
