package linked_list;

import java.util.Scanner;

/**
 * Problem 20: Linked List Cycle II (LeetCode 142)
 * 
 * Problem Statement:
 * Given the head of a linked list, return the node where the cycle begins. If
 * there is no cycle, return null.
 * 
 * Sample Input:
 * 4
 * 3 2 0 -4
 * 1
 * Sample Output:
 * Cycle begins at node with value: 2
 * 
 * Sample Input:
 * 1
 * 1
 * -1
 * Sample Output:
 * No cycle
 * 
 * Approach: Floyd's Cycle Detection + Math
 * 1. Use slow/fast pointers to detect if a cycle exists.
 * 2. If they meet, reset one pointer to head and move both one step at a time.
 * 3. They will meet at the cycle start.
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

public class LinkedListCycleII {
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
        ListNode[] nodes = new ListNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ListNode(sc.nextInt());
        }

        for (int i = 0; i < n - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        System.out.print("Enter cycle position (index, -1 for none): ");
        int pos = sc.nextInt();
        if (pos >= 0 && pos < n) {
            nodes[n - 1].next = nodes[pos];
        }

        ListNode cycleStart = detectCycle(nodes[0]);
        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }

        sc.close();
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // Cycle detected, find start
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}
