package tree;

import java.util.Scanner;

/**
 * Problem 15: Lowest Common Ancestor of Binary Tree (LeetCode 236)
 *
 * Input Format:
 * Number of nodes n, then n values in level-order (-1 for null),
 * followed by two node values p and q.
 *
 * Output Format:
 * Value of the lowest common ancestor.
 *
 * Approach: Post-order DFS. If we find p or q, return it. If both subtrees
 * return non-null,
 * current node is LCA.
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

public class LowestCommonAncestorBinaryTree {
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

        System.out.print("Enter values of p and q: ");
        int pVal = sc.nextInt();
        int qVal = sc.nextInt();

        // Find actual nodes
        TreeNode p = findNode(root, pVal);
        TreeNode q = findNode(root, qVal);

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("LCA: " + (lca != null ? lca.val : "null"));
        sc.close();
    }

    private static TreeNode findNode(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        TreeNode left = findNode(root.left, val);
        if (left != null)
            return left;
        return findNode(root.right, val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
