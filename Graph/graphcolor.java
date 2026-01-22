package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class graphcolor {
    public boolean graphColoring(int v, int[][] edges, int m) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] color = new int[v];
        return solve(0, adj, color, v, m);
    }

    private boolean solve(int node, List<List<Integer>> adj, int[] color, int n, int m) {
        if (node == n) {
            return true;
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(node, adj, color, c)) {
                color[node] = c;
                if (solve(node + 1, adj, color, n, m)) {
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int node, List<List<Integer>> adj, int[] color, int c) {
        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices (v): ");
        int v = sc.nextInt();

        System.out.print("Enter number of edges (e): ");
        int e = sc.nextInt();

        int[][] edges = new int[e][2];
        System.out.println("Enter edges (u v):");
        for (int i = 0; i < e; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        System.out.print("Enter number of colors (m): ");
        int m = sc.nextInt();

        graphcolor sol = new graphcolor();
        boolean result = sol.graphColoring(v, edges, m);

        if (result) {
            System.out.println("Output: YES (Graph can be colored with " + m + " colors)");
        } else {
            System.out.println("Output: NO (Graph cannot be colored with " + m + " colors)");
        }

        sc.close();
    }
}
