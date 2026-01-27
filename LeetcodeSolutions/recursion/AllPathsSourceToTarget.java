import java.util.*;

/**
 * Problem 16: All Paths From Source to Target
 * 
 * Input Format:
 * Number of nodes n, then for each node 0 to n-1, enter its neighbors separated
 * by space.
 * 
 * Output Format:
 * List of all paths from 0 to n-1.
 * 
 * Approach:
 * Backtracking (DFS) to find all paths in a Directed Acyclic Graph (DAG).
 */
public class AllPathsSourceToTarget {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        int[][] graph = new int[n][];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter neighbors of node " + i + ": ");
            String line = sc.nextLine();
            if (line.trim().isEmpty()) {
                graph[i] = new int[0];
            } else {
                String[] parts = line.split("\s+");
                graph[i] = new int[parts.length];
                for (int j = 0; j < parts.length; j++)
                    graph[i][j] = Integer.parseInt(parts[j]);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtrack(graph, 0, path, result);

        System.out.println("Paths: " + result);
        sc.close();
    }

    private static void backtrack(int[][] graph, int current, List<Integer> path, List<List<Integer>> result) {
        // Base case: reached destination (node n-1)
        if (current == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int next : graph[current]) {
            path.add(next);
            backtrack(graph, next, path, result);
            // Backtrack
            path.remove(path.size() - 1);
        }
    }
}
