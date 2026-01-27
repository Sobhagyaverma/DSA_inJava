package linked_list;

import java.util.Scanner;

/**
 * Problem 6: Odd Even Linked List (LeetCode 328)
 * 
 * Input Format:
 * Number of nodes n, followed by n values.
 * 
 * Output Format:
 * Linked list with odd indices first, then even indices.
 * 
 * Approach: Pointer Manipulation
 * We maintain two separate lists: one for odd-indexed nodes and one for
 * even-indexed nodes.
 * After traversing the entire list, we link the end of the odd list to the head
 * of the even list.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Why Optimal:
 * It rearranges nodes in-place in a single pass.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class OddEvenLinkedList {
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

        ListNode head = oddEvenList(dummy.next);

        System.out.print("Modified List: ");
        printList(head);

        sc.close();
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
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
