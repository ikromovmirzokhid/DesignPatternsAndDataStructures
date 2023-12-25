package designPatterns.iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ProductCollection products = new ProductCollection();
        products.addProduct("Apple");
        products.addProduct("Grape");
        products.addProduct("Strawberry");
        products.addProduct("Mandarin");
        products.addProduct("Orange");
        products.addProduct("Mango");
        Iterator<String> iterator = products.reverseIterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}