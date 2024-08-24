package datastructure.linkedlist.dsa;

public class DLL {

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int val) {
        Node node = new Node(val);
        if(head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }

    public void addLast(int val) {
        if(head == null) {
            addFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    public void add(int val, int index) {
        if(size == 0) {
            addFirst(val);
            return;
        }

        if(index > size) {
            addLast(val);
            return;
        }

        Node node = new Node(val);
        Node temp = get(index - 1);
        node.next = temp.next;
        if(size > 1) {
            node.next.prev = node;
        }
        temp.next = node;
        node.prev = temp;
        size++;
    }

    public int deleteFirst() {
        if(size == 0) {
            return -1;
        }
        int val = head.value;
        head = head.next;
        if(head == null) {
            tail = null;
            size--;
            return val;
        }
        head.prev = null;
        size--;
        return val;
    }

    public int deleteLast() {
        if(size == 0) {
            return -1;
        }
        int val = tail.value;
        tail = tail.prev;
        if(tail == null) {
            head = null;
            size--;
            return val;
        }
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index) {
        Node node = get(index);
        if(size == 1) {
            head = null;
            tail = null;
            size--;
            return node.value;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return node.value;
    }

    public Node get(int index) {
        if(head == null) {
            return null;
        }
        Node node = head;
        for(int i = 1; i <= index; i++) {
            node = head.next;
        }
        return node;
    }

    public void display() {
        Node node = head;
        while(node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
    }

    public void displayReverse() {
        Node node = tail;
        while(node != null) {
            System.out.print(node.value + " -> ");
            node = node.prev;
        }
    }

    public DLL() {
        size = 0;
    }

    private class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }

}
