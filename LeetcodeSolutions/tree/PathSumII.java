package tree;

import java.util.*;

/**
 * Problem 18: Path Sum II (LeetCode 113) - Note: Problem list says "Path Sum
 * III" but 113 is Path Sum II
 *
 * Input Format:
 * Number of nodes n, then n values in level-order (-1 for null),
 * followed by target sum.
 *
 * Output Format:
 * All root-to-leaf paths that sum to target.
 *
 * Approach: DFS with backtracking to collect all valid paths.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) for recursion + O(n) for storing paths.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class PathSumII {
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

        System.out.print("Enter target sum: ");
        int targetSum = sc.nextInt();

        List<List<Integer>> paths = pathSum(root, targetSum);
        System.out.println("Paths with sum " + targetSum + ":");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
        sc.close();
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private static void dfs(TreeNode node, int remaining, List<Integer> path, List<List<Integer>> result) {
        if (node == null)
            return;

        path.add(node.val);

        // Leaf node
        if (node.left == null && node.right == null && remaining == node.val) {
            result.add(new ArrayList<>(path));
        }

        dfs(node.left, remaining - node.val, path, result);
        dfs(node.right, remaining - node.val, path, result);

        path.remove(path.size() - 1); // Backtrack
    }
}
