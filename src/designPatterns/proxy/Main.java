package designPatterns.proxy;

public class Main {
    public static void main(String[] args) {
        CustomerService service = new CustomerService();
        service.getCustomer(1);
        service.getCustomer(1);

    }
}