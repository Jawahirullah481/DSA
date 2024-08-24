package datastructure.linkedlist.problems.doubly;

class Node {
    public int val;
    public Node next;
    public Node prev;

    Node()
    {
        this.val = 0;
        this.next = null;
        this.prev = null;
    }

    Node(int data)
    {
        this.val = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next)
    {
        this.val = data;
        this.next = next;
        this.prev = next;
    }

    public static Node getDLL() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        return getDLLFromArray(arr);
    }

    public static Node getDLLFromArray(int[] arr) {
        // [1, 2, 3, 4]
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            prev.next = node;
            node.prev = prev;

            prev = node;
        }

        return head;
    }

    public static void printDLL(Node node) {
        while(node != null) {
            System.out.print("=" + node.val + "=");
            node = node.next;
        }
        System.out.println();
    }
}