package designPatterns.template;

public class FileLogger extends Logger {
    @Override
    void open() {
        System.out.println("Open file");
    }

    @Override
    void writeMessage(String message) {
        System.out.println("write message - " + message + " to file");
    }

    @Override
    void close() {
        System.out.println("Close file");
    }
}
