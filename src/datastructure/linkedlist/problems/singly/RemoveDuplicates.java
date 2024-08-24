package datastructure.linkedlist.problems.singly;

public class RemoveDuplicates {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(1, node3);
        ListNode node5 = new ListNode(1, node4);
        System.out.print("Before Removing : ");
        node1.display(node5);
        deleteDuplicates(node5);
        System.out.print("After Removing : ");
        node1.display(node5);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        /*
            If the value of currentNode and next node are equal,
            then remove the nextnode and don't traverse.
            If they are not equal, then traverse.
        */
        ListNode node = head;
        while(node != null) {
            if(node.next != null && node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
    }
}
