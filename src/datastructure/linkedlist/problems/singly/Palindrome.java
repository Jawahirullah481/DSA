package datastructure.linkedlist.problems.singly;

public class Palindrome {
    public static void main(String[] args) {
        ListNode node8 = new ListNode(1);
        ListNode node7 = new ListNode(2, node8);
        ListNode node6 = new ListNode(3, node7);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        node1.display(node1);
        System.out.println("The Give Linked List is : " + ((isPalindrome(node1)) ? "Palindrome" : "not a Palindrome"));
    }

    public static boolean isPalindrome(ListNode head) {

        /*

            NOTE : In palindrome and reorder problem, you will reverse the second part of the linkedlist.
                   In both these problems, you won't do prev = firstPrev after you reverse it.
                   Because of this, the element before the middle element still points to the middle element.
                   So, finally the linkedlist is like below,

                   1 -> 2    5 -> 4 -> 3 -> null
                        |______________^

            In the above diagram, we are not breaking the linkage of 2 to 3. It still points to 3.

         */
        ListNode middle = findMiddle(head);
        ListNode secondHead = reverse(middle);

        while(secondHead != null) {
            if(head.val != secondHead.val) {
                return false;
            }
            head = head.next;
            secondHead = secondHead.next;
        }

        return true;
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
}
