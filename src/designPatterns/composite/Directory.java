package designPatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemComponent {
    private List<FileSystemComponent> fileSystemComponents = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    @Override
    int getSize() {
        size = 0;
        for (FileSystemComponent fileSystemComponent : fileSystemComponents)
            size += fileSystemComponent.getSize();
        return size;
    }

    @Override
    void print() {
        System.out.println("-- dir " + name + " size=" + getSize() + " bytes");
        for (FileSystemComponent fileSystemComponent : fileSystemComponents)
            fileSystemComponent.print();
    }

    public void addFileSystemComponent(FileSystemComponent fileSystemComponent) {
        fileSystemComponents.add(fileSystemComponent);
    }
}
