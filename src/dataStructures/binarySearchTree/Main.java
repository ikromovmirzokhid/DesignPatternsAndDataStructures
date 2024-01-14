package dataStructures.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(6);
        bst.add(9);
        bst.add(1);
        bst.add(4);
        bst.add(11);
        bst.add(6);
        bst.add(3);
        bst.add(0);
        bst.add(21);
        bst.add(45);
        System.out.println(bst.height());

    }
}