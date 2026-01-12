package Tree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node right, left;

    Node(int data) {
        this.data = data;
        left = right = null;

    }
}

public class Input {

    public static Node buildTree(int arr[], int i) {
        if (i >= arr.length || arr[i] == -1)
            return null;
        Node root = new Node(arr[i]);
        root.left = buildTree(arr, 2 * i + 1);
        root.right = buildTree(arr, 2 * i + 2);
        return root;
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }

    public static void levelOrder(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 3, 4, 5, 6, 7, 7, 8, 2 };
        Node root = buildTree(arr, 0);

        System.out.print("Inorder   : ");
        inorder(root);
        System.out.println();

        System.out.print("LevelOrder: ");
        levelOrder(root);
    }

}
