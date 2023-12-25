package designPatterns.composite;

public class File extends FileSystemComponent {

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    int getSize() {
        return size;
    }

    @Override
    void print() {
        System.out.println("--- file " + name + " size=" + getSize() + " bytes");
    }
}
