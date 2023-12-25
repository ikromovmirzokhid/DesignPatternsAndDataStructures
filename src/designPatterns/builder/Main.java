package designPatterns.builder;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer.Builder().setFirstName("Miz").setLastname("Ikromov").setAge(25).setMarried(false).setNumberOfChildren(0).build();
        System.out.println(customer);
    }
}