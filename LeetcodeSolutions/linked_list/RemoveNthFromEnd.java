package linked_list;

import java.util.Scanner;

/**
 * Problem 2: Remove Nth Node From End of List (LeetCode 19)
 * 
 * Problem Statement:
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head.
 * 
 * Sample Input:
 * 5
 * 1 2 3 4 5
 * 2
 * Sample Output:
 * 1 -> 2 -> 3 -> 5 -> null
 * 
 * Sample Input:
 * 1
 * 1
 * 1
 * Sample Output:
 * null
 * 
 * Approach: Two Pointers (Slow and Fast)
 * 1. Use a dummy node to handle the case where the head is removed.
 * 2. Move a 'fast' pointer k steps ahead.
 * 3. Move 'slow' and 'fast' pointers together until 'fast' reaches the end.
 * 4. 'slow' will then be at the node just before the one to be removed.
 * 
 * Time Complexity: O(n) - Single pass
 * Space Complexity: O(1)
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int total = sc.nextInt();

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        System.out.println("Enter node values:");
        for (int i = 0; i < total; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        System.out.print("Enter k (nth from end): ");
        int k = sc.nextInt();

        System.out.print("Original List: ");
        printList(dummy.next);

        ListNode head = removeNthFromEnd(dummy.next, k);

        System.out.print("Modified List: ");
        printList(head);

        sc.close();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n steps ahead
        for (int i = 0; i <= n; i++) {
            if (fast == null)
                return head; // n is larger than list size
            fast = fast.next;
        }

        // Move both until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the nth node from end
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return dummy.next;
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
