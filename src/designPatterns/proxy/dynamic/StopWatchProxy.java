package designPatterns.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StopWatchProxy implements InvocationHandler {
    private Object target;
    private StopWatch stopWatch;

    public StopWatchProxy(Object target) {
        this.target = target;
        stopWatch = new StopWatch();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        stopWatch.start();
        Object obj = method.invoke(target, args);
        stopWatch.stop();
        System.out.println("StopWatch Proxy: " + method.getName() + "called in " + stopWatch.getMillis() + " ms");
        return obj;
    }
}
