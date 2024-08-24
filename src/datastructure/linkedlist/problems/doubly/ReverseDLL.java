package datastructure.linkedlist.problems.doubly;

public class ReverseDLL {
    public static void main(String[] args) {
        Node head = Node.getDLL();
        System.out.println("Before reverse : ");
        Node.printDLL(head);
        System.out.println("After reverse : ");
        head = reverseDLL(head);
        Node.printDLL(head);
    }

    public static Node reverseDLL(Node node) {
        // 1 2 3 4
        Node head = node;
        Node prev = null;
        while(node != null) {
            Node temp = node.next;
            node.next = node.prev;
            node.prev = temp;
            if(node.prev == null) {
                head = node;
            }
            node = node.prev;
        }

        return head;
    }
}
