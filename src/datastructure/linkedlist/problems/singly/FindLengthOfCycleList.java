package datastructure.linkedlist.problems.singly;

public class FindLengthOfCycleList {

    public static void main(String[] args) {
        // Create the nodes
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        // Link the nodes together
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode meetingNode = detectCycle(node1);
        System.out.println("Cycle list meeting in : " + meetingNode.val);
    }

    public static ListNode detectCycle(ListNode head) {
        /*
            Step 1 : Find the length of the cycle list
            Step 2 : Move one pointer to length of the cycle list and put another pointer at first node.
            Step 3 : After moveing the 2nd node to the length of cycle list,
                        then move both the nodes one by one. At one point they will meet each other.
                        That's the meeting point.
         */

        int length = findLength(head);

        if(length == -1) {
            return null;
        }

        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while(length > 0) {
            pointer1 = pointer1.next;
            length--;
        }

        while(pointer1 != pointer2) {
             pointer1 = pointer1.next;
             pointer2 = pointer2.next;
        }

        return pointer1;

    }

    public static int findLength(ListNode head) {
        /*
            Step 1 : Use 2 pointer technique to find it is cylic or not.
            Step 2 : If it is cyclic at one point both pointer will meet.
            Step 3 : Move 1 pointer step by step until it meets the another pointer.
                     That's how you find the length.
         */

        ListNode pointer1 = head;
        ListNode pointer2 = head;

        boolean isCyclic = false;
        while(pointer2 != null && pointer2.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;

            if(pointer1 == pointer2) {
                isCyclic = true;
                break;
            }
        }

        if(isCyclic == false) {
            return -1;
        }

        int length = 0;
        do {
            pointer1 = pointer1.next;
            length++;
        } while(pointer1 != pointer2);

        return length;
    }
}
