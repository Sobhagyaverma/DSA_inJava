package tree;

import java.util.*;

/**
 * Problem 22: Binary Tree Vertical Order Traversal (LeetCode 314)
 *
 * Input Format:
 * Number of nodes n, then n values in level-order (-1 for null).
 *
 * Output Format:
 * List of vertical columns from left to right.
 *
 * Approach: BFS with column tracking. Use TreeMap to maintain column order,
 * and for each column maintain insertion order.
 *
 * Time Complexity: O(n log n) due to TreeMap
 * Space Complexity: O(n)
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Pair {
    TreeNode node;
    int col;

    Pair(TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}

public class BinaryTreeVerticalOrderTraversal {
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

        List<List<Integer>> result = verticalOrder(root);
        System.out.println("Vertical order traversal:");
        for (List<Integer> column : result) {
            System.out.println(column);
        }

        sc.close();
    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode node = p.node;
            int col = p.col;

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);

            if (node.left != null) {
                queue.offer(new Pair(node.left, col - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, col + 1));
            }
        }

        result.addAll(map.values());
        return result;
    }
}
