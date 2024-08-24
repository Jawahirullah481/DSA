package datastructure.linkedlist.problems.singly;

public class ReverseKNodes {

    public static void main(String[] args) {
        ListNode node8 = new ListNode(8);
        ListNode node7 = new ListNode(7, node8);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println("Before reveres : ");
        node1.display(node1);

        ListNode head = reverseKNodes(node1, 2);
        System.out.println("After reverse : ");
        head.display(head);
    }

    private static ListNode reverseKNodes(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        int length = findLength(head);
        int count = 1;
        while(count <= length) {
            ListNode firstPrev = prev;
            ListNode firstCurr = curr;

            for(int i = 1; curr != null && i <= k; i++) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if(next != null) {
                    next = next.next;
                }
                count++;
            }

            if(firstPrev != null) {
                firstPrev.next = prev;
            } else {
                head = prev;
            }

            firstCurr.next = curr;
            prev = firstCurr;

            int remNodes = length - count + 1;
            if(remNodes < k) {
                break;
            }
        }

        return head;
    }

    private static int findLength(ListNode head) {
        ListNode node = head;
        int length = 0;
        while(node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

}
