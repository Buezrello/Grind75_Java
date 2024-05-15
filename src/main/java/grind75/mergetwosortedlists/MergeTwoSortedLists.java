package grind75.mergetwosortedlists;

import java.util.List;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * @author Igor Gindin
 * @since 23/01/2023
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        final List<Integer> list1a = List.of(1, 2, 4);
        final List<Integer> list2a = List.of(1, 3, 4);
        final List<Integer> list1b = List.of();
        final List<Integer> list2b = List.of();
        final List<Integer> list1c = List.of();
        final List<Integer> list2c = List.of(0);

        final MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

        ListNode head1 = null;
        ListNode head2 = null;
        head1 = mergeTwoSortedLists.createNewLinkedList(head1, list1a);
        head2 = mergeTwoSortedLists.createNewLinkedList(head2, list2a);
        ListNode mergedHead = mergeTwoSortedLists.mergeTwoLists(head1, head2);
        mergeTwoSortedLists.printLinkedList(mergedHead);

        head1 = null;
        head2 = null;
        head1 = mergeTwoSortedLists.createNewLinkedList(head1, list1b);
        head2 = mergeTwoSortedLists.createNewLinkedList(head2, list2b);
        mergedHead = mergeTwoSortedLists.mergeTwoLists(head1, head2);
        mergeTwoSortedLists.printLinkedList(mergedHead);

        head1 = null;
        head2 = null;
        head1 = mergeTwoSortedLists.createNewLinkedList(head1, list1c);
        head2 = mergeTwoSortedLists.createNewLinkedList(head2, list2c);
        mergedHead = mergeTwoSortedLists.mergeTwoLists(head1, head2);
        mergeTwoSortedLists.printLinkedList(mergedHead);
    }

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        if (head1.val < head2.val) {
            head1.next = mergeTwoLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoLists(head1, head2.next);
            return head2;
        }
    }

    private ListNode createNewLinkedList(ListNode head, List<Integer> vals) {

        for (int val : vals) {
            head = addNodeToLast(head, new ListNode(val));
        }

        return head;
    }

    private ListNode addNodeToLast(ListNode head, ListNode listNode) {
        if (head == null) {
            return listNode;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = listNode;
            return head;
        }
    }

    private void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

