package datastructure.linkedlist.problems.singly;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode node11 = new ListNode(5);
        ListNode node12 = new ListNode(4, node11);
        ListNode node13 = new ListNode(3, node12);
        ListNode node14 = new ListNode(2, node13);
        ListNode node15 = new ListNode(1, node14);
        System.out.print("Before Sorting : List 1 -> ");
        node15.display(node15);
        ListNode node21 = new ListNode(8);
        ListNode node22 = new ListNode(7, node21);
        ListNode node23 = new ListNode(6, node22);
        ListNode node24 = new ListNode(5, node23);
        ListNode node25 = new ListNode(3, node24);
        System.out.print("Before Sorting : List 2 -> ");
        node15.display(node25);

        ListNode newNode = mergeSort(node15, node25);
        System.out.print("After Sorting  : List   -> ");
        newNode.display(newNode);
    }

    public static ListNode mergeSort(ListNode node1, ListNode node2) {
        /*
            List 1 -> 1 -> 2 -> 3 -> 4 -> 5
            List 2 -> 3 -> 5 -> 6 -> 7 -> 8

            1. In the beginning of the function, you have to create new node which has empty value;
            2. Then iterate normally using mergeSort
            3. Most import thing is after every iteration, you have to update the node = node.next;
            4. After the 1st while loop, unlike the merge sort in arrays, we can only use if statement for rest of list
            5. Because, if we link the top level node, then rest of the nodes of that list are connected by that node.
            
         */
        ListNode node = new ListNode();
        ListNode head = node;

        while(node1 != null && node2 != null) {
            if(node1.val < node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }

            node = node.next;
        }

        if(node1 != null) {
            node.next = node1;
        }

        if(node2 != null) {
            node.next = node2;
        }

        return head.next;
    }
}
