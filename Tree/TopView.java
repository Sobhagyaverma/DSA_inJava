package tree;



import java.util.*;

public class TopView {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Pair {
        Node node;
        int hd; // Horizontal Distance

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static Node buildTree(int[] arr, int i) {
        if (i >= arr.length || arr[i] == -1)
            return null;

        Node root = new Node(arr[i]);
        root.left = buildTree(arr, 2 * i + 1);
        root.right = buildTree(arr, 2 * i + 2);
        return root;
    }

    public static void topView(Node root) {
        if (root == null) return;

        // Queue for Level Order Traversal
        Queue<Pair> q = new LinkedList<>();
        // TreeMap to keep Horizontal Distances sorted (Left to Right)
        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            Node node = curr.node;
            int hd = curr.hd;

            // If this horizontal distance is seen for the first time, add it
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }
        }

        System.out.println("Top View of the Tree:");
        for (int value : map.values()) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter node values (-1 for null):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr, 0);

        topView(root);

        sc.close();
    }
}