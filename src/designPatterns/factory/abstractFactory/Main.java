package designPatterns.factory.abstractFactory;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        CustomerService customerService = new CustomerService();
        System.out.println(customerService.getCustomerById(1));
        System.out.println(productService.getProductById(1));
    }
}