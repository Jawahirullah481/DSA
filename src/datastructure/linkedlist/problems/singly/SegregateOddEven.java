package datastructure.linkedlist.problems.singly;

public class SegregateOddEven {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ListNode head = ListNode.getLLWithArray(arr);

        System.out.println("Before order :");
        ListNode.display(head);

        head = rearrangeOddEven(head);

        System.out.println("After order : ");
        ListNode.display(head);
    }

    public static ListNode rearrangeOddEven(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode prevOdd = head;
        ListNode secondHead = head.next;
        ListNode odd = head;
        ListNode even = head.next;


        while(odd != null && even != null) {
            prevOdd = odd;
            odd.next = even.next;
            odd = odd.next;
            if(odd != null) {
                even.next = odd.next;
                even = even.next;
            }
        }

        /*
            NOTE :
            ======
            1. In even number of nodes, when the loop terminates, odd will point to null.
               In that case, you have to preserve previous node to link with even head(secondHead).

            2. In odd number of nodes, when the loop terminates, only even will point to null.
               In that case, you can use odd itself to link with even head(secondHead).
         */
        if(odd != null) {
            odd.next = secondHead;
        } else {
            prevOdd.next = secondHead;
        }

        return head;
    }
}
