package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class VerticalTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Pair {
        TreeNode node;
        int row, col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null)
            return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();

            if (arr[i] != null) {
                curr.left = new TreeNode(arr[i]);
                q.add(curr.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                curr.right = new TreeNode(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        Map<Integer, List<int[]>> map = new TreeMap<>();
        Queue<Pair> q = new ArrayDeque<>();

        q.add(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            map.putIfAbsent(curr.col, new ArrayList<>());
            map.get(curr.col).add(new int[]{curr.row, curr.node.val});

            if (curr.node.left != null)
                q.add(new Pair(curr.node.left, curr.row + 1, curr.col - 1));

            if (curr.node.right != null)
                q.add(new Pair(curr.node.right, curr.row + 1, curr.col + 1));
        }

        List<List<Integer>> result = new ArrayList<>();

        for (List<int[]> list : map.values()) {
            list.sort((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });

            List<Integer> colList = new ArrayList<>();
            for (int[] arr : list)
                colList.add(arr[1]);

            result.add(colList);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Integer[] arr = new Integer[n];
        System.out.println("Enter node values in level order (-1 for null):");

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = (x == -1) ? null : x;
        }

        TreeNode root = buildTree(arr);
        List<List<Integer>> ans = verticalTraversal(root);

        System.out.println("Vertical Order Traversal:");
        for (List<Integer> col : ans) {
            System.out.println(col);
        }

        sc.close();
    }
}
