package linked_list;

import java.util.Scanner;

/**
 * Problem 3: Merge Two Sorted Lists (LeetCode 21)
 * 
 * Input Format:
 * List 1: size n1, values.
 * List 2: size n2, values.
 * 
 * Output Format:
 * The merged sorted linked list.
 * 
 * Approach: Iterative with Dummy Node
 * We use a dummy node to simplify the start of the list. We compare heads of
 * both lists
 * and attach the smaller node to the merged list, advancing that head.
 * 
 * Time Complexity: O(n1 + n2)
 * Space Complexity: O(1)
 * 
 * Why Optimal:
 * It merges in-place (reusing existing nodes) in a single pass.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of List 1: ");
        int n1 = sc.nextInt();
        ListNode l1 = buildList(sc, n1);

        System.out.print("Enter size of List 2: ");
        int n2 = sc.nextInt();
        ListNode l2 = buildList(sc, n2);

        System.out.print("List 1: ");
        printList(l1);
        System.out.print("List 2: ");
        printList(l2);

        ListNode merged = mergeTwoLists(l1, l2);

        System.out.print("Merged List: ");
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach the remaining part
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
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
