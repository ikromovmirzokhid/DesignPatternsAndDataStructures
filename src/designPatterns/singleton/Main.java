package designPatterns.singleton;

public class Main {
    public static void main(String[] args) {
        // reflection safety

//        try {
//            Constructor[] constructors = SingletonObject.class.getDeclaredConstructors();
//            for (Constructor constructor : constructors) {
//                constructor.setAccessible(true);
//                instance2 = (SingletonObject) constructor.newInstance();
//                break;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // thread safety
        Thread thread1 = new Thread(() -> {
            SingletonObject instance1 = SingletonObject.getInstance();
            System.out.println("Instance1 - " + instance1);
        });

        Thread thread2 = new Thread(() -> {
            SingletonObject instance2 = SingletonObject.getInstance();
            System.out.println("Instance2 - " + instance2);
        });
        thread1.start();
        thread2.start();
    }
}