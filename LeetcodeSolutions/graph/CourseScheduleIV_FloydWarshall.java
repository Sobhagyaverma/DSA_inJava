package graph;

import java.util.*;

/*
Problem Statement:
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that 
you must take course ai first if you want to take course bi.
For example, the pair [0, 1] indicates that you have to take course 0 before course 1.
Prerequisites can also be indirect. If course 0 is a prerequisite of course 1, 
and course 1 is a prerequisite of course 2, then course 0 is a prerequisite of course 2.
You are given a list of queries where queries[j] = [uj, vj]. 
For the jth query, you should answer whether course uj is a prerequisite of course vj or not.
Return a boolean array of answers.

Input Format:
- numCourses
- p prerequisites count, followed by pairs.
- q queries count, followed by pairs.

Output Format:
- List of booleans.

Constraints:
- 2 <= numCourses <= 100
- 0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)
*/

public class CourseScheduleIV_FloydWarshall {
    /**
     * Approach: Floyd-Warshall (Transitive Closure)
     * - We create a boolean matrix reachable[i][j] where i is a prerequisite of j.
     * - Initialize reachable[i][j] = true for direct prerequisites.
     * - Use Floyd-Warshall to find indirect prerequisites:
     * if i can reach k AND k can reach j, then i can reach j.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(V^3) - Floyd-Warshall.
     * - Space Complexity: O(V^2) - Reachability matrix.
     */
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isPrereq = new boolean[numCourses][numCourses];
        for (int[] p : prerequisites) {
            isPrereq[p[0]][p[1]] = true;
        }

        // Floyd-Warshall for transitive closure
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (isPrereq[i][k] && isPrereq[k][j]) {
                        isPrereq[i][j] = true;
                    }
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] q : queries) {
            result.add(isPrereq[q[0]][q[1]]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numCourses and prerequisites count:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[][] prereqs = new int[p][2];
        for (int i = 0; i < p; i++) {
            prereqs[i][0] = sc.nextInt();
            prereqs[i][1] = sc.nextInt();
        }
        System.out.println("Enter queries count:");
        int qCount = sc.nextInt();
        int[][] queries = new int[qCount][2];
        for (int i = 0; i < qCount; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        CourseScheduleIV_FloydWarshall solver = new CourseScheduleIV_FloydWarshall();
        System.out.println("Query Results: " + solver.checkIfPrerequisite(n, prereqs, queries));
        sc.close();
    }
}
