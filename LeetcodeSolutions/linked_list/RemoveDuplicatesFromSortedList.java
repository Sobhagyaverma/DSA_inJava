package linked_list;

import java.util.Scanner;

/**
 * Problem 14: Remove Duplicates from Sorted List (LeetCode 83)
 * 
 * Problem Statement:
 * Given the head of a sorted linked list, delete all duplicates such that each
 * element appears only once. Return the linked list sorted as well.
 * 
 * Sample Input:
 * 3
 * 1 1 2
 * Sample Output:
 * 1 -> 2 -> null
 * 
 * Sample Input:
 * 5
 * 1 1 2 3 3
 * Sample Output:
 * 1 -> 2 -> 3 -> null
 * 
 * Approach: Single Pass
 * Since the list is sorted, duplicates are adjacent.
 * We compare current node value with next node value.
 * If same, we skip the next node.
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

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        System.out.println("Enter sorted node values:");
        for (int i = 0; i < n; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }

        System.out.print("Original List: ");
        printList(dummy.next);

        ListNode head = deleteDuplicates(dummy.next);

        System.out.print("Modified List: ");
        printList(head);

        sc.close();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
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
