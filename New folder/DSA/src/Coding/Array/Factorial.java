package Array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Factorial {
    static ArrayList<Integer> factorial(int N) {
        // code here
        BigInteger val = BigInteger.valueOf(N);
        BigInteger fact = BigInteger.valueOf(1);
        for(int i=1;i<=N;i++){
            fact=fact.multiply(BigInteger.valueOf(i));
        }
        String str= String.valueOf(fact);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            arr.add(str.charAt(i)-'0');
        }
        return arr;
    }
    public static void main(String args[]){
        ArrayList<Integer> list=factorial(857);
        System.out.println(list+"size"+list.size());
    }
}

