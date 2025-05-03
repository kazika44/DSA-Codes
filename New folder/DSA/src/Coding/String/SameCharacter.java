package String;

import java.util.HashMap;
import java.util.Map;

public class SameCharacter {
    public static boolean sameCharacter(String str1, String str2, String shuffle){
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str1.length();i++){
            map.put(str1.charAt(i),map.getOrDefault(str1.charAt(i),0)+1);
        }
        for(int i=0;i<str2.length();i++) {
            map.put(str2.charAt(i), map.getOrDefault(str2.charAt(i), 0) + 1);
        }
        for(int i=0;i<shuffle.length();i++){
            if(map.containsKey(shuffle.charAt(i))) {
                map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);
            }
            else
                return false;
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()!=0)
                return false;

        }
        return true;
    }
}
