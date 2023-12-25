package designPatterns.factory.factoryMethod;

public class Main {
    public static void main(String[] args) {
        PhoneFactory factory = new PhoneFactory();
        System.out.println(factory.getPhone("samsung").getName());
    }
}