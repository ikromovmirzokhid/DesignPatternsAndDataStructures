package designPatterns.template;

public class Main {
    public static void main(String[] args) {
        FileLogger fileLogger = new FileLogger();
        fileLogger.log("Message for File");
        DatabaseLogger databaseLogger = new DatabaseLogger();
        databaseLogger.log("Message for Database");
    }
}