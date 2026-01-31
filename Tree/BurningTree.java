package tree;
import java.util.*;
public class BurningTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int minTime(Node root, int target) {
        if (root == null) return 0;

        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = mapParents(root, parentMap, target);

        return calculateBurnTime(targetNode, parentMap);
    }

    private static Node mapParents(Node root, Map<Node, Node> parentMap, int target) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node targetNode = null;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.data == target) {
                targetNode = curr;
            }

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                q.offer(curr.left);
            }

            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
        return targetNode;
    }

    private static int calculateBurnTime(Node targetNode, Map<Node, Node> parentMap) {
        if (targetNode == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(targetNode);
        
        Set<Node> visited = new HashSet<>();
        visited.add(targetNode);

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean burnedSomething = false;

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                    burnedSomething = true;
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                    burnedSomething = true;
                }

                if (parentMap.containsKey(curr) && !visited.contains(parentMap.get(curr))) {
                    Node parent = parentMap.get(curr);
                    visited.add(parent);
                    q.offer(parent);
                    burnedSomething = true;
                }
            }

            if (burnedSomething) {
                time++;
            }
        }

        return time;
    }

    public static Node buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;

        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node curr = q.poll();

            if (i < arr.length) {
                if (arr[i] != -1) {
                    curr.left = new Node(arr[i]);
                    q.add(curr.left);
                }
                i++;
            }

            if (i < arr.length) {
                if (arr[i] != -1) {
                    curr.right = new Node(arr[i]);
                    q.add(curr.right);
                }
                i++;
            }
        }
        return root;
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

        System.out.print("Enter target node value: ");
        int target = sc.nextInt();

        Node root = buildTree(arr);
        int result = minTime(root, target);

        System.out.println("Minimum time to burn tree: " + result);

        sc.close();
    }
}
