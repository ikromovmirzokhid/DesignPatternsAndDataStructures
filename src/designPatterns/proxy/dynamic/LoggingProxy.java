package designPatterns.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingProxy implements InvocationHandler {
    private Object target;

    public LoggingProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = method.invoke(target, args);
        System.out.println("Logging Proxy: " + method.getName() + "called with argument(s)");
        for (int i = 0; i < args.length; i++)
            System.out.println("arg[" + i + "] = " + args[i]);
        return obj;
    }
}
