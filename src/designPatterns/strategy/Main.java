package designPatterns.strategy;

public class Main {
    public static void main(String[] args) {
        ProductCollection products = new ProductCollection();
        SortStrategy sortStrategy = new MergeSort();
        products.setSortStrategy(sortStrategy);
        products.sort();
    }
}