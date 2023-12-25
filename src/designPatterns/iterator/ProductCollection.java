package designPatterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductCollection {
    private List<String> products = new ArrayList<>();

    void addProduct(String p) {
        products.add(p);
    }

    Iterator<String> reverseIterator() {
        return new ReverseIterator<>(products);
    }
}
