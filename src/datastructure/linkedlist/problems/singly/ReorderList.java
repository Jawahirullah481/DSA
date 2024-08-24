package datastructure.linkedlist.problems.singly;

public class ReorderList {
    public static void main(String[] args) {
        ListNode node8 = new ListNode(8);
        ListNode node7 = new ListNode(7, node8);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode middle = findMiddle(node1);
        ListNode secondHead = reverse(middle);
        ListNode head = node1;
        reorder(node1, secondHead);

        System.out.println("After reorder : ");
        head.display(head);
    }

    public static void reorder(ListNode first, ListNode second) {
        /*

            NOTE : In palindrome and reorder problems, after reverse we don't break the linkage of middle element to its previous element.
            So, after reverse, 2 nodes will point middle node and middle node will point null.
            Hence, the diagram will look like below.

            1 -> 2    5 -> 4 -> 3 -> null
                 |______________^
        
         */
        while(first != null && second != null) {
            ListNode nextFirst = first.next;
            ListNode nextSecond = second.next;

            first.next = second;
            first = nextFirst;
            second.next = first;
            second = nextSecond;
        }

        // In the odd number of listnodes, last first node will point itself as we don't break the linkage during reverse
        if(first != null) {
            first.next = null;
        }
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
