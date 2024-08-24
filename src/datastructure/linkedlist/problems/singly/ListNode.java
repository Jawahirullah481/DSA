package datastructure.linkedlist.problems.singly;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void display(ListNode head) {
        ListNode node = head;
        while(node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }

        System.out.println();
    }

    public static ListNode getLLWithArray(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;
        for(int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            prev.next = node;
            prev = prev.next;
        }

        return head;
    }
}
