package dataStructures.binarySearchTree;

import dataStructures.queue.Queue;

import java.util.Iterator;
import java.util.Stack;

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

    public void print(TraversalOrder order) {
        switch (order) {
            case PRE_ORDER -> {
                preOrderPrint(root);
                break;
            }
            case IN_ORDER -> {
                inOrderPrint(root);
                break;
            }
            case POST_ORDER -> {
                postOrderPrint(root);
                break;
            }
            case LEVEL_ORDER -> {
                levelOrderPrint(root);
                break;
            }
        }
    }

    private void preOrderPrint(Node node) {
        if (node == null)
            return;
        System.out.println(node.data);
        preOrderPrint(node.left);
        preOrderPrint(node.right);
    }

    private void inOrderPrint(Node node) {
        if (node == null)
            return;
        inOrderPrint(node.left);
        System.out.println(node.data);
        inOrderPrint(node.right);
    }

    private void postOrderPrint(Node node) {
        if (node == null)
            return;
        postOrderPrint(node.left);
        postOrderPrint(node.right);
        System.out.println(node.data);
    }

    private void levelOrderPrint(Node node) {
        Queue<Node> queue = new Queue<>();
        queue.enqueue(node);
        while (!queue.isEmpty()) {
            Node n = queue.dequeue();
            System.out.println(n.data);
            if (n.left != null)
                queue.enqueue(n.left);
            if (n.right != null)
                queue.enqueue(n.right);
        }
    }


    private Iterator<T> levelOrderIterator() {
        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public T next() {
                Node n = queue.dequeue();
                if (n.left != null)
                    queue.enqueue(n.left);
                if (n.right != null)
                    queue.enqueue(n.right);
                return n.data;
            }
        };
    }

    private Iterator<T> postOrderIterator() {
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        stack.push(temp);
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public T next() {
                Node root = stack.peek();
                addLeftNodeToStack(root);
                Node peek = stack.peek();
                while (peek.right != null) {
                    stack.add(peek.right);
                    addLeftNodeToStack(peek.right);
                    peek = peek.right;
                }
                Node current = stack.pop();
                if (!stack.isEmpty()) {
                    Node parent = stack.peek();
                    if(parent.data.compareTo(current.data) > 0)
                        parent.left = null;
                    else
                        parent.right = null;
                }
                return current.data;
            }

            private void addLeftNodeToStack(Node n) {
                while (n.left != null) {
                    stack.push(n.left);
                    n = n.left;
                }
            }
        };
    }

    private Iterator<T> inOrderIterator() {
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        stack.push(temp);
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public T next() {
                Node root = stack.peek();
                addToStack(root);
                Node current = stack.pop();
                if (!stack.isEmpty()) {
                    Node parent = stack.peek();
                    parent.left = null;
                }
                if (current.right != null)
                    stack.add(current.right);
                return current.data;
            }

            private void addToStack(Node n) {
                while (n.left != null) {
                    stack.push(n.left);
                    n = n.left;
                }
            }
        };
    }

    private Iterator<T> preOrderIterator() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public T next() {
                Node node = stack.pop();
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
                return node.data;
            }
        };
    }

}
