package designPatterns.composite;

public abstract class FileSystemComponent {
    protected String name;
    protected int size;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    abstract int getSize();

    abstract void print();
}
