package JAVA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {


//    Stream<String> emptyStream = Stream.empty();
//    System.out.print(emptyStream);
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();
        System.out.println(streamOfCollection.collect(Collectors.toList()));

        //Strem genereate()
        Stream<String> streamGenerate = Stream.generate(() -> "element").limit(10);
        System.out.println(streamGenerate.collect(Collectors.toList()));

        //Stream iterate()
        Stream<Integer> streamIterator = Stream.iterate(40, n -> n + 2).limit(20);
        System.out.println(streamIterator.collect(Collectors.toList()));

        //

        List<String> list = Arrays.asList("abcd", "hdjk", "huwiadhk", "hfuiew", "bbiufh");
//        System.out.println(list.stream().filter(str->str.contains("bc")).collect(Collectors.toList()));
        System.out.println(list.stream().map(String::length).collect(Collectors.toList()));
        //
        List<String> productlist1 = Arrays.asList("Printer", "Mouse", "Keyboard", "Motherboard");
        List<String>  productlist2 = Arrays.asList("Scanner", "Projector", "Light Pen");
        List<String> productlist3 = Arrays.asList("Pen Drive", "Charger", "WIFI Adapter", "Cooling Fan");
        List<String> productlist4 = Arrays.asList("CPU Cabinet", "WebCam", "USB Light", "Microphone", "Power cable");

        List<List<String>> allproducts = new ArrayList();

        allproducts.add(productlist1);
        allproducts.add(productlist2);
        allproducts.add(productlist3);
        allproducts.add(productlist4);
//        System.out.println(allproducts.forEach());
        System.out.println(allproducts.stream().flatMap(p->p.stream()).collect(Collectors.toList()));


    }

}
