package datastructure.linkedlist.problems.singly;

public class Add2Numbers {

    // Problem link : https://www.naukri.com/code360/problems/add-two-numbers_1170520?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries&leftPanelTabValue=PROBLEM

    public static void main(String[] args) {
        int[] arr1 = {9, 8, 7, 6};
        int[] arr2 = {5, 4, 3};

        ListNode head1 = ListNode.getLLWithArray(arr1);
        ListNode head2 = ListNode.getLLWithArray(arr2);

        ListNode resHead = addTwoList(head1, head2);
        System.out.println("After adding");
        ListNode.display(resHead);
    }

    public static ListNode addTwoList(ListNode head1, ListNode head2) {
        int rem = 0;
        ListNode head = null;
        ListNode prev = null;

        while(head1 != null && head2 != null) {
            int num1 = head1.val;
            int num2 = head2.val;
            int sum = num1 + num2 + rem;
            if(sum > 9) {
                sum = sum - 10;
                rem = 1;
            } else {
                rem = 0;
            }

            head1 = head1.next;
            head2 = head2.next;

            ListNode node = new ListNode(sum);
            if(head == null) {
                head = node;
                prev = head;
                continue;
            }

            prev.next = node;
            prev = prev.next;

        }

        while(head1 != null) {
            int num = head1.val;
            int sum = num + rem;
            if(sum > 9) {
                sum = sum - 10;
                rem = 1;
            } else {
                rem = 0;
            }

            head1 = head1.next;
            ListNode node = new ListNode(sum);
            if(head == null) {
                head = node;
                prev = head;
                continue;
            }

            prev.next = node;
            prev = prev.next;
        }

        while(head2 != null) {
            int num = head2.val;
            int sum = num + rem;
            if(sum > 9) {
                sum = sum - 10;
                rem = 1;
            } else {
                rem = 0;
            }

            head2 = head2.next;
            ListNode node = new ListNode(sum);
            if(head == null) {
                head = node;
                prev = head;
                continue;
            }

            prev.next = node;
            prev = prev.next;
        }

        return head;
    }
}
