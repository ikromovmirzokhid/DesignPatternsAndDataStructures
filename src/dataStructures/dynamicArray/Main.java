package dataStructures.dynamicArray;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        DynamicArray<String> strs = new DynamicArray<>();
        strs.add("a");
        strs.add("b");
        strs.add("c");
        strs.add("d");
        strs.add("e");
        System.out.println(strs);
        strs.remove("c");
        strs.remove("a");
        System.out.println(strs);
        strs.removeAt(1);
        strs.removeAt(0);
        System.out.println(strs);
        strs.add("c");
        strs.add("d");
        strs.add("e");
        System.out.println(strs);
        strs.set(2, "qwerty");
        System.out.println(strs);
        System.out.println(strs.size());
        System.out.println(strs.indexOf("d"));
        Iterator<String> iterator = strs.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
        System.out.println(strs.contains("f"));
    }
}