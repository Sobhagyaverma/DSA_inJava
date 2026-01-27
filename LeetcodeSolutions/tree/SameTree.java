package tree;

import java.util.Scanner;

/**
 * Problem 2: Same Tree (LeetCode 100)
 *
 * Input Format:
 * Number of nodes n, then n values in level-order for Tree A (use -1 for null),
 * followed by n values for Tree B (same ordering).
 *
 * Output Format:
 * true if the two trees are structurally identical with same node values, false
 * otherwise.
 *
 * Approach: Recursive comparison of corresponding nodes.
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

public class SameTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes for each tree (level-order, -1 for null): ");
        int n = sc.nextInt();
        TreeNode[] aNodes = new TreeNode[n];
        TreeNode[] bNodes = new TreeNode[n];
        System.out.println("Enter values for Tree A:");
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            if (v != -1)
                aNodes[i] = new TreeNode(v);
        }
        System.out.println("Enter values for Tree B:");
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            if (v != -1)
                bNodes[i] = new TreeNode(v);
        }
        // Link children for both trees
        linkChildren(aNodes);
        linkChildren(bNodes);
        TreeNode rootA = n > 0 ? aNodes[0] : null;
        TreeNode rootB = n > 0 ? bNodes[0] : null;
        System.out.println("Same Tree? " + isSameTree(rootA, rootB));
        sc.close();
    }

    private static void linkChildren(TreeNode[] nodes) {
        int n = nodes.length;
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
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
