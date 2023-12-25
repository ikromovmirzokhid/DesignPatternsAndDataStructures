package designPatterns.template;

abstract class Logger {
    public void log(String message) {
        String serializedMessage = serialize(message);
        open();
        writeMessage(message);
        close();
    }

    private String serialize(String message) {
        System.out.println("serialize message");
        return message;
    }

    abstract void open();
    abstract void writeMessage(String message);
    abstract void close();
}
