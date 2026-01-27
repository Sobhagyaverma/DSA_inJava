package linked_list;

import java.util.Scanner;

/**
 * Problem 15: Reverse Nodes in k-Group (LeetCode 25)
 * 
 * Input Format:
 * Number of nodes n, values, and k.
 * 
 * Output Format:
 * Modified linked list.
 * 
 * Approach: Iterative Reversal in Batches
 * 1. Count if at least k nodes exist.
 * 2. If yes, reverse those k nodes.
 * 3. Use recursion or an iterative loop to handle the next batch.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) (iterative) or O(n/k) (recursive)
 * 
 * Why Optimal:
 * It reverses the list in-place and handles the remainder correctly.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseNodesInKGroup {
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

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.print("Original List: ");
        printList(dummy.next);

        ListNode head = reverseKGroup(dummy.next, k);

        System.out.print("Modified List: ");
        printList(head);

        sc.close();
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy, nex = dummy, pre = dummy;
        int count = 0;

        // Count total nodes
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }

        while (count >= k) {
            cur = pre.next; // first node of k-group
            nex = cur.next; // second node of k-group
            for (int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            count -= k;
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
