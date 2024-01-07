package dataStructures.queue;

public class Main {
    public static void main(String[] args) {
//        Queue<Integer> queue = new Queue<>(1);
//        queue.enqueue(2);
//        queue.enqueue(3);
//        queue.enqueue(4);
//        queue.dequeue();
//        queue.dequeue();
//        queue.enqueue(5);
//        System.out.println(queue);

        Queue1<Integer> queue = new Queue1<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(5);
        System.out.println(queue);
    }
}