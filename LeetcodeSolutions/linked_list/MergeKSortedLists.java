package linked_list;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Problem 11: Merge K Sorted Lists (LeetCode 23)
 * 
 * Input Format:
 * Number of sorted lists k, then for each list: size and values.
 * 
 * Output Format:
 * Single merged sorted linked list.
 * 
 * Approach: Min-Priority Queue
 * 1. Add the head of each non-empty list to a min-heap.
 * 2. Repeatedly extract the minimum node, attach it to the result,
 * and add the next node of that list to the heap.
 * 
 * Time Complexity: O(N log k) where N is total nodes.
 * Space Complexity: O(k) for the priority queue.
 * 
 * Why Optimal:
 * It efficiently finds the smallest element among k lists in log(k) time.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeKSortedLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of sorted lists (k): ");
        int k = sc.nextInt();

        ListNode[] lists = new ListNode[k];
        for (int i = 0; i < k; i++) {
            System.out.print("Enter size of list " + (i + 1) + ": ");
            int n = sc.nextInt();
            lists[i] = buildList(sc, n);
        }

        ListNode merged = mergeKLists(lists);

        System.out.print("Merged Merged List: ");
        printList(merged);

        sc.close();
    }

    private static ListNode buildList(Scanner sc, int n) {
        if (n <= 0)
            return null;
        System.out.println("Enter node values:");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int i = 0; i < n; i++) {
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }
        return dummy.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null)
                pq.add(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) {
                pq.add(node.next);
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
