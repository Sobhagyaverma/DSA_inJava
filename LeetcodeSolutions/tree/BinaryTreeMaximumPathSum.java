package tree;

import java.util.Scanner;

/**
 * Problem 7: Binary Tree Maximum Path Sum (LeetCode 124)
 *
 * Input Format:
 * Number of nodes n, then n values in level-order (-1 for null).
 *
 * Output Format:
 * Integer representing the maximum path sum (any path, not necessarily from
 * root to leaf).
 *
 * Approach: Post‑order DFS. For each node compute the maximum gain from
 * left/right
 * sub‑trees and update a global maximum.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) recursion stack.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeMaximumPathSum {
    private static int maxSum;

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
        maxSum = Integer.MIN_VALUE;
        maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxSum);
        sc.close();
    }

    private static int maxPathSum(TreeNode node) {
        if (node == null)
            return 0;
        int left = Math.max(0, maxPathSum(node.left));
        int right = Math.max(0, maxPathSum(node.right));
        // Path that passes through this node
        int current = node.val + left + right;
        maxSum = Math.max(maxSum, current);
        // Return max gain to parent
        return node.val + Math.max(left, right);
    }
}
