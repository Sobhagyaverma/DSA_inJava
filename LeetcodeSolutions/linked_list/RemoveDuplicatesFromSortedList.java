package linked_list;

import java.util.Scanner;

/**
 * Problem 14: Remove Duplicates from Sorted List (LeetCode 83)
 * 
 * Input Format:
 * Number of nodes n, values (must be sorted).
 * 
 * Output Format:
 * Modified list without duplicates.
 * 
 * Approach: Single Pass
 * Since the list is sorted, duplicates are adjacent.
 * We compare current node value with next node value.
 * If same, we skip the next node.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Why Optimal:
 * It removes all duplicates in a single pass using constant extra space.
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
