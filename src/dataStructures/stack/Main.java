package dataStructures.stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.push(5);
        stack.pop();
        stack.push(7);
        System.out.println(stack);
    }
}