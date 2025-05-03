package String;

import java.util.HashMap;
import java.util.Map;

public class DuplicateElements {
    public static void duplicate(String str){
        Map<Character,Integer> map= new HashMap<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,map.getOrDefault(c,1));
            }
        }
        for(Map.Entry<Character,Integer> mapElement:map.entrySet()){
            if(mapElement.getValue()>1){
                System.out.println("elements:"+mapElement.getKey()+ " "+"count:"+mapElement.getValue());
            }
        }
    }
    public static void main(String []args){
        String str="geeksforgeeks";
        duplicate(str);
    }
}
