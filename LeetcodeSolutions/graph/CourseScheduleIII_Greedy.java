package graph;

import java.util.*;

/*
Problem Statement:
There are n different online courses numbered from 1 to n. You are given an array 
courses where courses[i] = [durationi, lastDayi] indicate that the ith course 
should be taken continuously for durationi days and must be finished before or 
on lastDayi.
Return the maximum number of courses that you can take.

Input Format:
- n (number of courses)
- n pairs of [duration, lastDay]

Output Format:
- Max courses count.

Constraints:
- 1 <= courses.length <= 10^4
- 1 <= durationi, lastDayi <= 10^4
*/

public class CourseScheduleIII_Greedy {
    /**
     * Approach: Greedy + Max-Heap
     * - We sort courses by their deadline (lastDay). This is a greedy common
     * strategy.
     * - We process courses one by one. Maintain current total time.
     * - If adding a course exceeds its deadline, but its duration is shorter than
     * the longest course we've already taken, we swap them.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(N log N) - Sorting and heap operations.
     * - Space Complexity: O(N) - Max heap.
     */
    public int scheduleCourse(int[][] courses) {
        // Sort by deadline
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        // Max-heap to track durations of taken courses
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int totalTime = 0;

        for (int[] c : courses) {
            int duration = c[0];
            int lastDay = c[1];

            if (totalTime + duration <= lastDay) {
                totalTime += duration;
                pq.offer(duration);
            } else if (!pq.isEmpty() && pq.peek() > duration) {
                // Swap the longest course with this shorter one to free up time
                totalTime -= pq.poll();
                totalTime += duration;
                pq.offer(duration);
            }
        }

        return pq.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of courses:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();
        int[][] courses = new int[n][2];
        System.out.println("Enter [duration, lastDay] pairs:");
        for (int i = 0; i < n; i++) {
            courses[i][0] = sc.nextInt();
            courses[i][1] = sc.nextInt();
        }

        CourseScheduleIII_Greedy solver = new CourseScheduleIII_Greedy();
        System.out.println("Max success: " + solver.scheduleCourse(courses));
        sc.close();
    }
}
