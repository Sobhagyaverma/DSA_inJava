package graph;

import java.util.*;

/*
Problem Statement:
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that 
you must take course bi first if you want to take course ai.
Return true if you can finish all courses. Otherwise, return false.

Input Format:
- numCourses (integer)
- p (number of prerequisites)
- p pairs of [ai, bi]

Output Format:
- Boolean (true if possible, false otherwise)

Constraints:
- 1 <= numCourses <= 2000
- 0 <= prerequisites.length <= 5000
*/

public class CourseSchedule_TopologicalSort {
    /**
     * Approach: Kahn's Algorithm (Topological Sort)
     * - We represent courses as nodes and prerequisites as directed edges.
     * - Calculate the indegree for each node.
     * - Start with nodes with indegree 0 (courses with no prerequisites).
     * - Process each such node, removing its outgoing edges and updating neighbors'
     * indegrees.
     * - If we can process all nodes, there's no cycle; otherwise, a cycle exists.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(V + E) - Build graph and process all nodes/edges.
     * - Space Complexity: O(V + E) - Adjacency list and indegree array.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]); // p[1] -> p[0]
            indegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of courses:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        System.out.println("Enter number of prerequisites:");
        int p = sc.nextInt();
        int[][] prereqs = new int[p][2];
        System.out.println("Enter pairs [course, prerequisite]:");
        for (int i = 0; i < p; i++) {
            prereqs[i][0] = sc.nextInt();
            prereqs[i][1] = sc.nextInt();
        }

        CourseSchedule_TopologicalSort solver = new CourseSchedule_TopologicalSort();
        System.out.println("Can finish all courses: " + solver.canFinish(n, prereqs));
        sc.close();
    }
}
