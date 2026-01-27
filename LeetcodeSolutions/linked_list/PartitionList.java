package linked_list;

import java.util.Scanner;

/**
 * Problem 22: Partition List (LeetCode 86)
 * 
 * Input Format:
 * Number of nodes n, values, and partition value x.
 * 
 * Output Format:
 * Modified linked list with nodes < x before nodes >= x.
 * 
 * Approach: Two Separate Lists
 * 1. Create two separate lists: one for nodes < x, one for nodes >= x.
 * 2. Traverse the original list and append nodes to the appropriate list.
 * 3. Connect the two lists.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Why Optimal:
 * It partitions the list in a single pass while maintaining relative order.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class PartitionList {
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

        System.out.print("Enter partition value x: ");
        int x = sc.nextInt();

        System.out.print("Original List: ");
        printList(dummy.next);

        ListNode head = partition(dummy.next, x);

        System.out.print("Partitioned List: ");
        printList(head);

        sc.close();
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null; // Important: prevent cycle
        before.next = afterHead.next;

        return beforeHead.next;
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
