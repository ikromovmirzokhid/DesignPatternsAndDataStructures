package dataStructures.linkedHashMap;

import java.util.HashMap;
import java.util.Map;

public class LinkedHashMap<T, R> {
    private class ListNode {
        private T key;
        private R value;
        ListNode prev;
        ListNode next;

        public ListNode(T key, R value) {
            this.key = key;
            this.value = value;
        }

        public ListNode() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    "-> value=" + value +
                    '}';
        }
    }

    private ListNode head;
    private ListNode tail;
    private Map<T, ListNode> dc;
    private int capacity;

    public LinkedHashMap(int capacity) {
        this.capacity = capacity;
        dc = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }

    public void put(T key, R value) {
        if (dc.get(key) != null) {
            ListNode node = dc.get(key);
            remove(node);
        }
        ListNode newNode = new ListNode(key, value);
        dc.put(key, newNode);
        add(newNode);
        if (dc.size() > capacity) {
            dc.remove(head.next.key);
            remove(head.next);
        }
    }

    public R get(T key) {
        if (dc.get(key) == null)
            return null;
        ListNode node = dc.get(key);
        remove(node);
        add(node);
        return node.value;
    }

    private void add(ListNode node) {
        ListNode previousNode = tail.prev;
        node.prev = previousNode;
        previousNode.next = node;
        tail.prev = node;
        node.next = tail;
    }

    private void remove(ListNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    @Override
    public String toString() {
        ListNode temp = head;
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            sb.append(temp).append(", ");
            temp = temp.next;
        }
        if (sb.length() != 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
