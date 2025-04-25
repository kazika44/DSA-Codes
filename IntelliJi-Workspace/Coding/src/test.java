import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String args[]){
        List<String> d= Arrays.asList("a", "b","a","b");
        for(int i=0; i< d.size();i++){
            if(d.get(i).equals("b"))
                d.remove(4);
        }
        System.out.println(d);

    }
}
