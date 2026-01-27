package linked_list;

import java.util.Scanner;

/**
 * Problem 10: Delete Node in a Linked List (LeetCode 237)
 * 
 * Input Format:
 * List values and the value of the node to delete (guaranteed not to be the
 * tail).
 * 
 * Output Format:
 * Modified linked list.
 * 
 * Approach: Node Data Swap
 * Since we don't have access to the previous node, we copy the data from the
 * next node
 * into the current node and then delete the next node.
 * 
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * 
 * Why Optimal:
 * It deletes the node in constant time without traversing the list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class DeleteNodeInLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode nodeToDelete = null;

        System.out.println("Enter node values:");
        int[] vals = new int[n];
        for (int i = 0; i < n; i++)
            vals[i] = sc.nextInt();

        System.out.print("Enter value of node to delete: ");
        int target = sc.nextInt();

        for (int i = 0; i < n; i++) {
            curr.next = new ListNode(vals[i]);
            curr = curr.next;
            if (vals[i] == target)
                nodeToDelete = curr;
        }

        System.out.print("Original List: ");
        printList(dummy.next);

        if (nodeToDelete != null && nodeToDelete.next != null) {
            deleteNode(nodeToDelete);
            System.out.print("Modified List: ");
            printList(dummy.next);
        } else {
            System.out.println("Node not found or node is tail (not allowed by problem).");
        }

        sc.close();
    }

    public static void deleteNode(ListNode node) {
        // Copy next node's value and skip it
        node.val = node.next.val;
        node.next = node.next.next;
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
