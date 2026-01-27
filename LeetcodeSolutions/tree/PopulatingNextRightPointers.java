package tree;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Problem 10: Populating Next Right Pointers in Each Node (LeetCode 116)
 *
 * Input Format:
 * Number of nodes n, then n values in level-order (-1 for null).
 *
 * Output Format:
 * Prints each level showing node values and the value of their next pointer (or
 * null).
 *
 * Approach: BFS level order. For each level, link nodes' next pointers.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for the queue.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next; // pointer to next right node

    TreeNode(int val) {
        this.val = val;
    }
}

public class PopulatingNextRightPointers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes (level-order, -1 for null): ");
        int n = sc.nextInt();
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            if (v != -1)
                nodes[i] = new TreeNode(v);
        }
        // link children
        for (int i = 0; i < n; i++) {
            if (nodes[i] == null)
                continue;
            int leftIdx = 2 * i + 1;
            int rightIdx = 2 * i + 2;
            if (leftIdx < n)
                nodes[i].left = nodes[leftIdx];
            if (rightIdx < n)
                nodes[i].right = nodes[rightIdx];
        }
        TreeNode root = n > 0 ? nodes[0] : null;
        connect(root);
        System.out.println("Next pointers per level (node->next):");
        printNextPointers(root);
        sc.close();
    }

    private static void connect(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode prev = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (prev != null)
                    prev.next = node;
                prev = node;
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            // last node's next stays null
        }
    }

    private static void printNextPointers(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                String nextVal = (node.next == null) ? "null" : String.valueOf(node.next.val);
                System.out.print(node.val + "->" + nextVal + " ");
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            System.out.println();
        }
    }
}
