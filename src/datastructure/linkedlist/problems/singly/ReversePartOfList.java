package datastructure.linkedlist.problems.singly;

public class ReversePartOfList {
    public static void main(String[] args) {
        ListNode node8 = new ListNode(8);
        ListNode node7 = new ListNode(7, node8);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.print("Before Reverse : ");
        node1.display(node1);
        System.out.print("After Reverse from 2 to 5 : ");
        node1.display(reverse(node1, 2, 5));
    }

    public static ListNode reverse(ListNode head, int left, int right) {
        /*
            NOTE : At first, current should point to first node to be reversed.
                   At Last, currnt should point to next of last node to be reversed.
         */
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        int pos = 1;
        while(pos < left) {
            prev = curr;
            curr = next;
            next = next.next;
            pos++;
        }

        // NOTE : Preserve following for linkage after reversed
        ListNode node1 = prev;
        ListNode node2 = curr;

        while(pos <= right && curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) {
                next = next.next;
            }
            pos++;
        }

        if(node1 == null) {
            prev = head;
        } else {
            node1.next = prev;
        }

        node2.next = curr;

        return head;
    }
}
