package designPatterns.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CachingProxy implements InvocationHandler {
    private Map<Integer, Object> cache = new HashMap<>();
    private Object target;

    public CachingProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Integer id = (Integer) args[0];
        Object cachedObject = cache.get(id);
        if (cachedObject == null) {
            Object obj = method.invoke(target, args);
            cache.put(id, obj);
            System.out.println("Caching Proxy: " + method.getName() + "called");
            return obj;
        }
        System.out.println("Caching Proxy: getting data from cache");
        return cachedObject;
    }
}
