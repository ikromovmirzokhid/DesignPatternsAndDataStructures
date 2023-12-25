package designPatterns.singleton;

public class SingletonObject {
    private static SingletonObject singletonObject;

    private SingletonObject() {
        if (singletonObject != null)
            throw new RuntimeException("User getInstance to get Singleton Object");
    }

    public static SingletonObject getInstance() {
        synchronized (SingletonObject.class) {
            if (singletonObject == null) {
                singletonObject = new SingletonObject();
            }
        }
        return singletonObject;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
