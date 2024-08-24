package datastructure.linkedlist.problems.singly;

public class ReverseLIst {
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
        System.out.print("After Reverse : ");
        node1.display(reverseList(node1));
    }

    public static ListNode reverseList(ListNode head) {
        /*
            Here, we are using 3 pointers technique.
            1 -> prev -> to hold the prev node.
            2 -> curr -> to hold the current node.
            3 -> next -> to hold the next node.

            Why we need prev ?
            ==================
            Because, we need to make current point next element as its previous node.

            Why we need next ?
            ==================
            After, current node points its next as prev node, then how can it move to the next element.
            So, we need next to move further.

            Note : At first, prev points to null and current points to the first element.

            Note : After reversed, the last prev becomes new head.

         */

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;

            if (next != null) {
                next = next.next;
            }
        }

        return prev;
    }
}
