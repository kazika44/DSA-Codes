package JavaImpl;

import java.util.*;
import java.util.concurrent.*;

// Class 1
// Helper class representing Student
class Student {
    int rollno;
    String name, address;

    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    public String toString() {
        return this.rollno + " " + this.name + " "
                + this.address;
    }
}

// Class 3
// Main class
public class tree {

    static void Example2nd() {
//        TreeMap<Student, Integer> tree_map = new TreeMap<Student, Integer>((a,b) -> a.rollno-b.rollno); // O(1)


        TreeMap<Student, Integer> tree_map = new TreeMap<Student, Integer>((a,b) -> a.name.compareTo(b.name));

        tree_map.put(new Student(111, "bbbb", "london"), 2); // O(log n)
        tree_map.put(new Student(131, "aaaa", "nyc"), 3); // O(log n)
        tree_map.put(new Student(121, "cccc", "jaipur"), 1); // O(log n)

        System.out.println("TreeMap: " + tree_map); // O(n)
    }

    public static void main(String[] args) {
        System.out.println("TreeMap using TreeMap(Comparator) constructor:\n");
        Example2nd(); // O(n log n) for put and
        // O(n) for printing
    }
}

