package designPatterns.factory.abstractFactory;

public class Product {
    private String name;
    private int productNumber;

    public Product(String name, int productNumber) {
        this.name = name;
        this.productNumber = productNumber;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", productNumber=" + productNumber +
                '}';
    }
}
