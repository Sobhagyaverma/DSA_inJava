package graph;

import java.util.*;

/*
Problem Statement:
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that 
you must take course bi first if you want to take course ai.
Return the ordering of courses you should take to finish all courses. 
If there are many valid answers, return any of them. If it is impossible to finish 
all courses, return an empty array.

Input Format:
- numCourses (integer)
- p (number of prerequisites)
- p pairs of [ai, bi]

Output Format:
- Array of integers representing the course sequence.

Constraints:
- 1 <= numCourses <= 2000
*/

public class CourseScheduleII_TopologicalSort {
    /**
     * Approach: Kahn's Algorithm
     * - Similar to Course Schedule I, but we store the sequence of processed nodes.
     * - The process order is a valid topological sort order.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(V + E)
     * - Space Complexity: O(V + E)
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index++] = curr;

            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return (index == numCourses) ? order : new int[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numCourses and prerequisites count:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();
        int pCount = sc.nextInt();

        int[][] prereqs = new int[pCount][2];
        System.out.println("Enter prerequisites [course, prereq]:");
        for (int i = 0; i < pCount; i++) {
            prereqs[i][0] = sc.nextInt();
            prereqs[i][1] = sc.nextInt();
        }

        CourseScheduleII_TopologicalSort solver = new CourseScheduleII_TopologicalSort();
        int[] result = solver.findOrder(n, prereqs);

        if (result.length == 0) {
            System.out.println("No valid order possible.");
        } else {
            System.out.println("Course Order: " + Arrays.toString(result));
        }
        sc.close();
    }
}
