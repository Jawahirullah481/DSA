package datastructure.linkedlist.dsa;

public class LL {

    public Node head;
    public Node tail;
    public int size;

    public LL() {
        size = 0;
    }

    public void addFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail == null) {
            tail = head;
        }
        size++;
    }

    public void addLast(int val) {
        if(tail == null) {
            addFirst(val);
            size++;
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void add(int val, int index) {
        if(index == 0) {
            addFirst(val);
            return;
        }
        Node temp = head;
        for(int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public Node addUsingRecursion(int val, int index, Node node) {
        /*
            1 -> 2 -> 3 -> 4

         */
        if(index == 0) {
            Node newNode = new Node(val);
            newNode.next = node;
            size++;
            if(node == this.head) {
                head = newNode;
            }
            return newNode;
        }

        node.next = addUsingRecursion(val, index - 1, node.next);
        return node;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast() {

        if(size <= 1) {
            return deleteFirst();
        }

        Node temp = head;
        for(int i = 1; i <= size - 2; i++) {
            temp = temp.next;
        }

        int val = tail.value;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    public int delete(int index) {
        if(head.next == null && index == 0) {
            deleteFirst();
        }
        Node temp = head;
        for(int i = 1; i <= index - 1; i++) {
            temp = temp.next;
        }
        int val = temp.next.value;
        temp.next = temp.next.next;
        size--;
        return val;
    }

    public Node get(int index) {

        Node currentNode = head;
        for(int i = 1; i <= index; i++) {
            currentNode = head.next;
        }

        return currentNode;
    }

    public void display() {
        if(head == null) {
            return;
        }
        Node node = head;
        do {
            System.out.print(node.value + " -> ");
            node = node.next;
        } while(node != null);
    }

    public void display(Node head) {
        Node currentNode = head;
        while(currentNode != null) {
            System.out.print(currentNode.value + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }


    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LL list = new LL();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.addUsingRecursion(6, 0, list.head);
        list.display();
    }

}
