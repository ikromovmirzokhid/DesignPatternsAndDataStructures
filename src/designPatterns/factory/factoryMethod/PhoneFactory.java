package designPatterns.factory.factoryMethod;

public class PhoneFactory {
    Phone getPhone(String type) {
        if (type.equals("samsung"))
            return new SamsungPhone();
        else if (type.equals("iPhone"))
            return new Iphone();
        else return null;
    }
}
