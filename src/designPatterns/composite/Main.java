package designPatterns.composite;

public class Main {
    public static void main(String[] args) {
        Directory cdir = new Directory("C");
        Directory appdir = new Directory("applications");
        Directory datadir = new Directory("my data");
        Directory coursedir = new Directory("cs525");
        File excelfile = new File("msexcel.exe", 2353256);
        File wordfile = new File("msword.exe", 3363858);
        File studentsfile = new File("students.doc", 34252);
        cdir.addFileSystemComponent(appdir);
        cdir.addFileSystemComponent(datadir);
        datadir.addFileSystemComponent(coursedir);
        appdir.addFileSystemComponent(excelfile);
        appdir.addFileSystemComponent(wordfile);
        coursedir.addFileSystemComponent(studentsfile);
        cdir.print();
    }
}