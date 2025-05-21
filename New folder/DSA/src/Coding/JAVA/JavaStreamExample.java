package JAVA;

import java.util.*;
import java.util.stream.Collectors;

class Product {
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public static String removeDuplicateChars(String input) {
        return input.chars() // Convert to IntStream of characters
                .distinct()  // Remove duplicates
                .mapToObj(c -> String.valueOf((char) c)) // Convert int to String
                .collect(Collectors.joining()); // Join back into a single string
    }
}

public class JavaStreamExample {
    public static void main(String[] args) {

        String str = "programming";
        String result = Product.removeDuplicateChars(str);
        System.out.println("Original: " + str);
        System.out.println("Without duplicates: " + result);


//        List<Product> productsList = new ArrayList<Product>();
//        //Adding Products
//        productsList.add(new Product(1, "HP Laptop", 25000f));
//        productsList.add(new Product(2, "Dell Laptop", 30000f));
//        productsList.add(new Product(3, "Lenevo Laptop", 28000f));
//        productsList.add(new Product(4, "Sony Laptop", 28000f));
//        productsList.add(new Product(5, "Apple Laptop", 90000f));
//        System.out.println(productsList);
//        List<Product> productPriceList2 = productsList.stream().toList();
//        productPriceList2.forEach(product -> System.out.println(product));
    }
}