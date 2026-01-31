package linked_list;

import java.util.Scanner;

/**
 * Problem 18: Swap Nodes in Pairs (LeetCode 24)
 * 
 * Problem Statement:
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 * 
 * Sample Input:
 * 4
 * 1 2 3 4
 * Sample Output:
 * 2 -> 1 -> 4 -> 3 -> null
 * 
 * Sample Input:
 * 1
 * 1
 * Sample Output:
 * 1 -> null
 * 
 * Approach: Iterative Pointer Manipulation
 * We use a dummy node and swap pairs iteratively by adjusting pointers.
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

public class SwapNodesInPairs {
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

        ListNode head = swapPairs(dummy.next);

        System.out.print("Modified List: ");
        printList(head);

        sc.close();
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swap
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev forward
            prev = first;
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
