package linked_list;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Problem 21: Remove Zero Sum Consecutive Nodes (LeetCode 1171)
 * 
 * Input Format:
 * Number of nodes n, followed by n values.
 * 
 * Output Format:
 * Modified linked list with zero-sum consecutive nodes removed.
 * 
 * Approach: Prefix Sum with HashMap
 * 1. Calculate prefix sums while traversing the list.
 * 2. If a prefix sum repeats, it means the nodes between have sum = 0.
 * 3. Use a HashMap to track prefix sum -> node mapping.
 * 4. Remove zero-sum sequences by adjusting pointers.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) for the HashMap.
 * 
 * Why Optimal:
 * It removes all zero-sum sequences in linear time using prefix sum technique.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RemoveZeroSumConsecutiveNodes {
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

        ListNode head = removeZeroSumSublists(dummy.next);

        System.out.print("Modified List: ");
        printList(head);

        sc.close();
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        HashMap<Integer, ListNode> prefixSumMap = new HashMap<>();
        int prefixSum = 0;

        // First pass: build prefix sum map
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            prefixSum += curr.val;
            prefixSumMap.put(prefixSum, curr);
        }

        // Second pass: remove zero-sum sequences
        prefixSum = 0;
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            prefixSum += curr.val;
            curr.next = prefixSumMap.get(prefixSum).next;
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
