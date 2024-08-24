package datastructure.linkedlist.problems.singly;

public class CheckIfCycleLL {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);

        // Link the nodes together
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        node1.display(node1);
        System.out.println("Is Cyclic List : " + isCyclicList(node1));
    }

    public static boolean isCyclicList(ListNode node) {
        ListNode oneStep = node;
        ListNode twoStep = node;

        while(twoStep != null && twoStep.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;

            if(oneStep == twoStep) {
                return true;
            }
        }

        return false;
    }

}
