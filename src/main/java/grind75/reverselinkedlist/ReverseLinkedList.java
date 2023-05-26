package grind75.reverselinkedlist;

import java.util.List;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * @author Igor Gindin
 * @since 23/01/2023
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return temp;
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

