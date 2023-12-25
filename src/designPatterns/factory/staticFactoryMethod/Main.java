package designPatterns.factory.staticFactoryMethod;

public class Main {
    public static void main(String[] args) {
        RandomIntegerGenerator randomIntegerGenerator1 = RandomIntegerGenerator.between(1, 100);
        System.out.println(randomIntegerGenerator1.nextInt());

        RandomIntegerGenerator randomIntegerGenerator2 = RandomIntegerGenerator.up(100);
        System.out.println(randomIntegerGenerator2.nextInt());

        RandomIntegerGenerator randomIntegerGenerator3 = RandomIntegerGenerator.down(100);
        System.out.println(randomIntegerGenerator3.nextInt());
    }
}