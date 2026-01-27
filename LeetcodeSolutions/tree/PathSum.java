package tree;

import java.util.Scanner;

/**
 * Problem 8: Path Sum (LeetCode 112)
 *
 * Input Format:
 * Number of nodes n, then n values in level-order (-1 for null),
 * followed by an integer target sum.
 *
 * Output Format:
 * true if there exists a root‑to‑leaf path whose sum equals target, false
 * otherwise.
 *
 * Approach: DFS recursion accumulating path sum.
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

public class PathSum {
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
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();
        System.out.println("Has path sum? " + hasPathSum(root, target));
        sc.close();
    }

    public static boolean hasPathSum(TreeNode node, int sum) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null) {
            return node.val == sum;
        }
        int remaining = sum - node.val;
        return hasPathSum(node.left, remaining) || hasPathSum(node.right, remaining);
    }
}
