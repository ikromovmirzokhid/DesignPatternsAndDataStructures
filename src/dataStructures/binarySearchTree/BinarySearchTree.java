package dataStructures.binarySearchTree;

import java.util.Iterator;

import static dataStructures.binarySearchTree.TraversalOrder.PRE_ORDER;

enum TraversalOrder {
    PRE_ORDER,
    IN_ORDER,
    POST_ORDER,
    LEVEL_ORDER
}

public class BinarySearchTree<T extends Comparable<T>> {
    int size;
    Node root;

    private class Node {
        private T data;
        private Node left;
        private Node right;

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T elem) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            int cmp = elem.compareTo(temp.data);
            if (cmp < 0) temp = temp.left;
            else if (cmp > 0) temp = temp.right;
            else return true;
        }
        return false;
    }

    public boolean add(T elem) {
        if (contains(elem))
            return false;
        root = add(root, elem);
        size++;
        return true;
    }

    private Node add(Node node, T elem) {
        if (node == null)
            return new Node(elem, null, null);
        int cmp = elem.compareTo(node.data);
        if (cmp < 0)
            node.left = add(node.left, elem);
        else
            node.right = add(node.right, elem);

        return node;
    }

    public boolean remove(T elem) {
        if (!contains(elem))
            return false;
        root = remove(root, elem);
        size--;
        return true;
    }

    private Node remove(Node node, T elem) {
        int cmp = elem.compareTo(node.data);
        if (cmp < 0) {
            node.left = remove(node.left, elem);
        } else if (cmp > 0) {
            node.right = remove(node.right, elem);
        } else {
            if (node.left == null) {
                Node right = node.right;
                node.data = null;
                node = null;
                return right;
            } else if (node.right == null) {
                Node left = node.left;
                node.data = null;
                node = null;
                return left;
            } else {
                Node rightSmallestNode = digLeft(node.right);
                node.data = rightSmallestNode.data;
                node.right = remove(node.right, rightSmallestNode.data);
            }
        }
        return node;
    }

    private Node digLeft(Node node) {
        Node temp = node;
        while (temp.left != null)
            temp = temp.left;
        return temp;
    }

    private Node digRight(Node node) {
        Node temp = node;
        while (temp.right != null)
            temp = temp.right;
        return temp;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public Iterator<T> iterator(TraversalOrder order) {
        switch (order) {
            case PRE_ORDER -> {
                return preOrderIterator();
            }
            case IN_ORDER -> {
                return inOrderIterator();
            }
            case POST_ORDER -> {
                return postOrderIterator();
            }
            case LEVEL_ORDER -> {
                return levelOrderIterator();
            }
        }
        return null;
    }

    private Iterator<T> levelOrderIterator() {
        return null;
    }

    private Iterator<T> postOrderIterator() {
        return null;
    }

    private Iterator<T> inOrderIterator() {
        return null;
    }

    private Iterator<T> preOrderIterator() {
        return null;
    }

}
