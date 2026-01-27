package tree;

import java.util.Scanner;

/**
 * Problem 11: Sum Root to Leaf Numbers (LeetCode 129)
 *
 * Input Format:
 * Number of nodes n, then n values in level-order (-1 for null).
 *
 * Output Format:
 * Integer representing the sum of all root-to-leaf numbers.
 *
 * Approach: DFS - accumulate the number formed along each path and sum at
 * leaves.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) recursion stack.
 *
 * Edge Cases:
 * - Empty tree: return 0
 * - Single node: return that node's value
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SumRootToLeafNumbers {
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
        System.out.println("Sum of root-to-leaf numbers: " + sumNumbers(root));
        sc.close();
    }

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode node, int currentSum) {
        if (node == null)
            return 0;

        currentSum = currentSum * 10 + node.val;

        // Leaf node
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}
