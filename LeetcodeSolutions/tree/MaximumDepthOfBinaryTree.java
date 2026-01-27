package tree;

import java.util.Scanner;
import java.util.Stack;

/**
 * Problem 1: Maximum Depth of Binary Tree (LeetCode 104)
 *
 * Input Format:
 * Number of nodes n, then n values in level-order (use -1 for null).
 *
 * Output Format:
 * Integer representing the maximum depth.
 *
 * Approach: DFS (Recursive)
 * We compute depth as 1 + max(depth(left), depth(right)).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) where h is tree height (recursion stack).
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class MaximumDepthOfBinaryTree {
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
        // Link children
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
        System.out.println("Maximum Depth: " + maxDepth(root));
        sc.close();
    }

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
