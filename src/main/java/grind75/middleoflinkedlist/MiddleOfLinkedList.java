package grind75.middleoflinkedlist;

import java.util.List;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 *
 * @author Igor Gindin
 * @since 23/01/2023
 */
public class MiddleOfLinkedList {

    public static void main(String[] args) {
        final List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        final List<Integer> list2 = List.of(1, 2, 3, 4, 5, 6);

        final MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();


        final ListNode head1 = middleOfLinkedList.createNewLinkedList(list1);
        final ListNode head2 = middleOfLinkedList.createNewLinkedList(list2);

        middleOfLinkedList.printLinkedList(middleOfLinkedList.middleNode(head1));
        middleOfLinkedList.printLinkedList(middleOfLinkedList.middleNode(head2));
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode createNewLinkedList(List<Integer> vals) {
        ListNode head = null;

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


