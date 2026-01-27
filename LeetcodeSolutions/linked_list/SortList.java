package linked_list;

import java.util.Scanner;

/**
 * Problem 17: Sort List (LeetCode 148)
 * 
 * Input Format:
 * Number of nodes n, followed by n values.
 * 
 * Output Format:
 * Sorted linked list.
 * 
 * Approach: Merge Sort (Top-Down)
 * 1. Find the middle using slow/fast pointers.
 * 2. Recursively sort the left and right halves.
 * 3. Merge the two sorted halves.
 * 
 * Time Complexity: O(n log n)
 * Space Complexity: O(log n) for recursion stack.
 * 
 * Why Optimal:
 * Merge sort is the most efficient comparison-based sort for linked lists,
 * achieving O(n log n) time without requiring random access.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class SortList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }

        System.out.print("Original List: ");
        printList(dummy.next);

        ListNode head = sortList(dummy.next);

        System.out.print("Sorted List: ");
        printList(head);

        sc.close();
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Find middle
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // Split the list

        // Recursively sort both halves
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // Merge sorted halves
        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;
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
