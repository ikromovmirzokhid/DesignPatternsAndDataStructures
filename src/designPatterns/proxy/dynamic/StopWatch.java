package designPatterns.proxy.dynamic;

public class StopWatch {

    private long startTime = 0L;
    private long endTime = 0L;

    void start() {
        startTime = System.currentTimeMillis();
    }

    void stop() {
        endTime = System.currentTimeMillis();
    }

    long getMillis() {
        return endTime - startTime;
    }
}
