package linked_list;

import java.util.Scanner;

/**
 * Problem 10: Delete Node in a Linked List (LeetCode 237)
 * 
 * Problem Statement:
 * Write a function to delete a node in a singly-linked list. You will not be
 * given access to the head of the list,
 * instead you will be given access to the node to be deleted directly.
 * It is guaranteed that the node to be deleted is not a tail node in the list.
 * 
 * Sample Input:
 * List: 4-5-1-9, Node: 5
 * Sample Output:
 * List becomes: 4-1-9
 * 
 * Sample Input:
 * List: 4-5-1-9, Node: 1
 * Sample Output:
 * List becomes: 4-5-9
 * 
 * Approach: Node Data Swap
 * Since we don't have access to the previous node, we copy the data from the
 * next node
 * into the current node and then delete the next node.
 * 
 * Time Complexity: O(1)
 * Space Complexity: O(1)
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
