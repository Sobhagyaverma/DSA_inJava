package linked_list;

import java.util.Scanner;

/**
 * Problem 4: Linked List Cycle (LeetCode 141)
 * 
 * Input Format:
 * Number of nodes n, values, and the pos (index) nodes connects to (-1 for no
 * cycle).
 * 
 * Output Format:
 * Boolean indicating if a cycle exists.
 * 
 * Approach: Floyd's Tortoise and Hare (Two Pointers)
 * We use two pointers, 'slow' and 'fast'. 'slow' moves one step at a time,
 * while 'fast' moves two steps. If there's a cycle, they will eventually meet.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Why Optimal:
 * It detects the cycle without using extra space (like a HashSet).
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListCycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Cycle exists: false");
            sc.close();
            return;
        }

        System.out.println("Enter node values:");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode tail = null;
        ListNode cycleTarget = null;

        ListNode[] nodes = new ListNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ListNode(sc.nextInt());
            current.next = nodes[i];
            current = current.next;
            tail = current;
        }

        System.out.print("Enter cycle position (index, -1 for none): ");
        int pos = sc.nextInt();
        if (pos >= 0 && pos < n) {
            tail.next = nodes[pos];
        }

        System.out.println("Cycle exists: " + hasCycle(dummy.next));

        sc.close();
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
