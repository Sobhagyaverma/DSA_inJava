package linked_list;

import java.util.Scanner;

/**
 * Problem 13: Rotate List (LeetCode 61)
 * 
 * Problem Statement:
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * Sample Input:
 * 5
 * 1 2 3 4 5
 * 2
 * Sample Output:
 * 4 -> 5 -> 1 -> 2 -> 3 -> null
 * 
 * Sample Input:
 * 3
 * 0 1 2
 * 4
 * Sample Output:
 * 2 -> 0 -> 1 -> null
 * 
 * Approach: Link Tail to Head
 * 1. Find the length and the tail node.
 * 2. Link the tail to the head to form a ring.
 * 3. Traverse length - (k % length) - 1 steps and break the ring.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RotateList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("null");
            sc.close();
            return;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.print("Original List: ");
        printList(dummy.next);

        ListNode head = rotateRight(dummy.next, k);

        System.out.print("Rotated List: ");
        printList(head);

        sc.close();
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        // 1. Find length and tail
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // 2. Normalize k
        k %= len;
        if (k == 0)
            return head;

        // 3. Link tail to head
        tail.next = head;

        // 4. Find the new tail
        ListNode newTail = head;
        for (int i = 0; i < len - k - 1; i++) {
            newTail = newTail.next;
        }

        // 5. Break the link
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
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
