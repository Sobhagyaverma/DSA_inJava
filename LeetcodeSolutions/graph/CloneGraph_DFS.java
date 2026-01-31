package graph;

import java.util.*;

/*
Problem Statement:
Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

Input Format:
- Adjacency list representation provided to the cloneGraph function.
- In the main method, we will take n (number of nodes) and the edges to build the graph.

Output Format:
- The function returns the cloned graph's root node.

Constraints:
- The number of nodes in the graph is in the range [0, 100].
- 1 <= Node.val <= 100
- Node.val is unique for each node.
- There are no repeated edges and no self-loops in the graph.
- The Graph is connected and all nodes can be visited starting from the given node.
*/

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph_DFS {
    /**
     * Graph Construction & Logic:
     * - We use a HashMap to keep track of already cloned nodes (val -> clonedNode).
     * - Use DFS to traverse the original graph. For each node, if it's not in the
     * map,
     * create a copy and recursively clone its neighbors.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(V + E) - We visit each node and each edge once.
     * - Space Complexity: O(V) - For the map and the recursion stack.
     */
    private Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        // If node already cloned, return it from map
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        // Create a new clone
        Node clone = new Node(node.val);
        map.put(clone.val, clone);

        // Iterate neighbors and recursively clone them
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes and number of edges:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();
        int e = sc.nextInt();

        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++)
            nodes[i] = new Node(i);

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            nodes[u].neighbors.add(nodes[v]);
            nodes[v].neighbors.add(nodes[u]);
        }

        CloneGraph_DFS solver = new CloneGraph_DFS();
        Node clonedRoot = solver.cloneGraph(nodes[1]);

        System.out.println("Successfully cloned graph root with value: " + clonedRoot.val);
        sc.close();
    }
}
