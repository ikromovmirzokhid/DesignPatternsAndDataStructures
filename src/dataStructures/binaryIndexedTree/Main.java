package dataStructures.binaryIndexedTree;

public class Main {
    public static void main(String[] args) {
        BinaryIndexedTree binaryIndexedTree = new BinaryIndexedTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(binaryIndexedTree.sum(7));
        binaryIndexedTree.update(0, -1);
        System.out.println(binaryIndexedTree.sum(7));
    }
}