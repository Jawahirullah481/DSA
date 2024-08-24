package datastructure.linkedlist.problems.singly;

import datastructure.linkedlist.dsa.LL;
import datastructure.linkedlist.dsa.LL.Node;

public class AddUsingRecursion {
    public static void main(String[] args) {
        LL list = new LL();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        Node head = addUsingRecursion(5, 2, list.head);
        list.display(head);
        head = addUsingRecursion(6, 0, list.head);
        list.display(head);
    }

    private static Node addUsingRecursion(int val, int index, Node node) {
        /*
            1 -> 2 -> 3 -> 4 -> 5
         */
        if(index == 0) {
            Node newNode = new Node(val);
            newNode.next = node;
            return newNode;
        }

        node.next = addUsingRecursion(val, index - 1, node.next);
        return node;
    }

}
