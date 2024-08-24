package datastructure.linkedlist.problems.singly;

public class MiddleNode {

    public static void main(String[] args) {
        // Create the nodes
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        // Link the nodes together
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.print("Nodes : ");
        node1.display(node1);
        System.out.print("Middle node is : " + middleNode(node1).val);
    }
    public static ListNode middleNode(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;

        while(fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return slowNode;
    }
}
