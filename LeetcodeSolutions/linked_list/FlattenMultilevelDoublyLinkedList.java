package linked_list;

import java.util.Scanner;

/**
 * Problem 23: Flatten a Multilevel Doubly Linked List (LeetCode 430)
 * 
 * Input Format:
 * Simplified input: number of nodes and their values (child pointers handled
 * manually).
 * 
 * Output Format:
 * Flattened doubly linked list.
 * 
 * Approach: DFS with Stack or Recursion
 * 1. Traverse the list. When we encounter a child pointer, we recursively
 * flatten the child.
 * 2. Insert the flattened child between current node and next node.
 * 3. Continue until all levels are flattened.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) for recursion stack in worst case.
 * 
 * Why Optimal:
 * It flattens the multilevel list in a single traversal.
 */

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }
}

public class FlattenMultilevelDoublyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes in main list: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("null");
            sc.close();
            return;
        }

        Node dummy = new Node(0);
        Node curr = dummy;
        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.nextInt());
            curr.next = newNode;
            newNode.prev = curr;
            curr = newNode;
        }

        System.out.println("Flattening list (child pointers not set in this simple example)...");
        Node head = flatten(dummy.next);

        System.out.print("Flattened List: ");
        printList(head);

        sc.close();
    }

    public static Node flatten(Node head) {
        if (head == null)
            return null;

        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node next = curr.next;
                Node child = flatten(curr.child);

                // Connect current to child
                curr.next = child;
                child.prev = curr;
                curr.child = null;

                // Find the tail of child list
                Node tail = child;
                while (tail.next != null) {
                    tail = tail.next;
                }

                // Connect tail to next
                if (next != null) {
                    tail.next = next;
                    next.prev = tail;
                }
            }
            curr = curr.next;
        }

        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
