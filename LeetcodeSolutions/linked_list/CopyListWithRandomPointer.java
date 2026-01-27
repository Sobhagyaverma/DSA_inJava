package linked_list;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Problem 9: Copy List with Random Pointer (LeetCode 138)
 * 
 * Input Format:
 * Number of nodes n, values and random indices for each node.
 * 
 * Output Format:
 * Deep copy of the linked list.
 * 
 * Approach: Iterative with HashMap
 * We use a HashMap to map original nodes to their copies.
 * First pass creates all nodes, second pass connects 'next' and 'random'
 * pointers.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) for the map.
 * 
 * Why Optimal:
 * It handles arbitrary 'random' pointers in linear time.
 */

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
    }
}

public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("null");
            sc.close();
            return;
        }

        Node[] nodes = new Node[n];
        int[] randomIndices = new int[n];
        System.out.println("Enter node values and random indices (0 to n-1, -1 for null):");
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(sc.nextInt());
            randomIndices[i] = sc.nextInt();
        }

        // Link next pointers
        for (int i = 0; i < n - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        // Link random pointers
        for (int i = 0; i < n; i++) {
            if (randomIndices[i] >= 0 && randomIndices[i] < n) {
                nodes[i].random = nodes[randomIndices[i]];
            }
        }

        Node copy = copyRandomList(nodes[0]);
        System.out.println("Deep copy created successfully.");
        printListWithRandom(copy);

        sc.close();
    }

    public static Node copyRandomList(Node head) {
        if (head == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;

        // Pass 1: create copies
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Pass 2: connect pointers
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    private static void printListWithRandom(Node head) {
        Node temp = head;
        while (temp != null) {
            String randomVal = (temp.random == null) ? "null" : String.valueOf(temp.random.val);
            System.out.print("[" + temp.val + ", random: " + randomVal + "] -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
