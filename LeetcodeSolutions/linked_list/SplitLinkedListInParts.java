package linked_list;

import java.util.Scanner;

/**
 * Problem 16: Split Linked List in Parts (LeetCode 725)
 * 
 * Problem Statement:
 * Given the head of a singly linked list and an integer k, split the linked
 * list into k consecutive linked list parts.
 * The length of each part should be as equal as possible.
 * 
 * Sample Input:
 * Head: 1-2-3, k=5
 * Sample Output:
 * [[1],[2],[3],[],[]]
 * 
 * Sample Input:
 * Head: 1-2-3-4-5-6-7-8-9-10, k=3
 * Sample Output:
 * [[1,2,3,4],[5,6,7],[8,9,10]]
 * 
 * Approach: Math and Pointer Modification
 * 1. Find total length of the list.
 * 2. Calculate size of each part: base_size = length / k, extra = length % k.
 * 3. Split the list into k parts, where the first 'extra' parts have size
 * base_size + 1.
 * 
 * Time Complexity: O(n + k)
 * Space Complexity: O(k) for the result array.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class SplitLinkedListInParts {
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

        ListNode[] result = splitListToParts(dummy.next, k);

        System.out.println("Parts:");
        for (int i = 0; i < k; i++) {
            System.out.print("Part " + (i + 1) + ": ");
            printList(result[i]);
        }

        sc.close();
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] parts = new ListNode[k];
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        int n = len / k, r = len % k;
        curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            parts[i] = curr;
            int partSize = n + (i < r ? 1 : 0);
            for (int j = 0; j < partSize - 1; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }

        return parts;
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
