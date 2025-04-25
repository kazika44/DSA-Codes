package JAVA;


import java.util.HashMap;

class HashMapExample2 extends Thread {
    static HashMap<Integer, String> h = new HashMap<Integer, String>();

    public void run() {
        try {
            Thread.sleep(1000);
//         Child thread trying to add object
//         Adding new element in the object with the key 103
            h.put(103, "A");
        } catch (InterruptedException e) {
            System.out.println("Child Thread will add objects");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        h.put(100, "X");
        h.put(101, "Y");
        h.put(102, "Z");
        HashMapExample2 t = new HashMapExample2();
        t.start();
        for (Object o : h.entrySet()) {
            Object s = o;
            System.out.println(s);
            Thread.sleep(1000);
        }
        System.out.println(h);
    }
}

