package designPatterns.template;

public class DatabaseLogger extends Logger {
    @Override
    void open() {
        System.out.println("open database connection");
    }

    @Override
    void writeMessage(String message) {
        System.out.println("Write message - " + message + " to db");
    }

    @Override
    void close() {
        System.out.println("Close Database connection");
    }
}
