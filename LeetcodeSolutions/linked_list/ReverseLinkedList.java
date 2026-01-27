package linked_list;

import java.util.Scanner;

/**
 * Problem 1: Reverse Linked List (LeetCode 206)
 * 
 * Input Format:
 * Number of nodes n, followed by n node values.
 * 
 * Output Format:
 * The reversed linked list: val1 -> val2 -> ... -> null
 * 
 * Approach: Iterative In-place Reversal
 * We use three pointers: prev, current, and nextNode.
 * We traverse the list once, flipping the 'next' pointer of each node to point
 * to the previous node.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Why Optimal:
 * It visits each node exactly once and uses a constant amount of extra space.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("null");
            sc.close();
            return;
        }

        System.out.println("Enter node values:");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int i = 0; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        ListNode head = dummy.next;
        System.out.print("Original List: ");
        printList(head);

        ListNode reversedHead = reverseList(head);

        System.out.print("Reversed List: ");
        printList(reversedHead);

        sc.close();
    }

    public static ListNode reverseList(ListNode head) {
        // Edge cases: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next; // Store next node
            curr.next = prev; // Reverse pointer
            prev = curr; // Move prev forward
            curr = nextNode; // Move curr forward
        }

        return prev; // New head of reversed list
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
