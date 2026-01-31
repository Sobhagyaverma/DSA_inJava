package linked_list;

import java.util.Scanner;

/**
 * Problem 5: Remove Linked List Elements (LeetCode 203)
 * 
 * Problem Statement:
 * Given the head of a linked list and an integer val, remove all the nodes of
 * the linked list that has Node.val == val, and return the new head.
 * 
 * Sample Input:
 * 7
 * 1 2 6 3 4 5 6
 * 6
 * Sample Output:
 * 1 -> 2 -> 3 -> 4 -> 5 -> null
 * 
 * Sample Input:
 * 0
 * 1
 * Sample Output:
 * null
 * 
 * Approach: Iterative with Dummy Node
 * We use a dummy node to handle cases where the head itself needs to be
 * removed.
 * We traverse the list, and for each node, if the next node's value matches the
 * target,
 * we skip it by changing current.next to current.next.next.
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

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        ListNode dummyInput = new ListNode(0);
        ListNode inputCurr = dummyInput;
        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            inputCurr.next = new ListNode(sc.nextInt());
            inputCurr = inputCurr.next;
        }

        System.out.print("Enter target value to remove: ");
        int val = sc.nextInt();

        System.out.print("Original List: ");
        printList(dummyInput.next);

        ListNode head = removeElements(dummyInput.next, val);

        System.out.print("Modified List: ");
        printList(head);

        sc.close();
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next; // Remove element
            } else {
                curr = curr.next; // Move forward
            }
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
