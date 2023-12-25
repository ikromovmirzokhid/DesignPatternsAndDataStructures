package designPatterns.strategy;

import java.util.ArrayList;
import java.util.List;

public class ProductCollection {
    private List<String> products = new ArrayList<>();
    private SortStrategy sortStrategy;

    public void setSortStrategy(SortStrategy s) {
        sortStrategy = s;
    }

    public void sort() {
        sortStrategy.sort(products);
    }

    public void add(String product) {
        products.add(product);
    }
}
