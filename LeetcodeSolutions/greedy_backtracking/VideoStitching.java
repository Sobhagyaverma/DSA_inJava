package greedy_backtracking;

import java.util.Arrays;
import java.util.Scanner;

/*
Problem Statement:
You are given a series of video clips from a sporting event that lasted time seconds. 
These video clips can be overlapped with each other and have varying lengths.
Each video clip is described by an array clips where clips[i] = [starti, endi] 
indicates that the ith clip started at starti and ended at endi.
We can cut these clips into segments freely.
Return the minimum number of clips needed so that we can cut the clips into segments 
that cover the entire sporting event [0, time]. If the task is impossible, return -1.

Input Format:
- n (number of clips)
- n pairs of integers (start, end)
- time (the target duration)

Output Format:
- Minimum clips or -1

Constraints:
1 <= clips.length <= 100
0 <= starti <= endi <= 100
1 <= time <= 100

Sample Input:
9
0 2
4 6
8 10
1 9
1 5
5 9
0 5
2 3
0 10
10
Sample Output:
3 (0 5, 5 9, 8 10 or 0 10) -> Actually 1 (0 10) is possible here.
*/

public class VideoStitching {
    /**
     * Greedy Choice:
     * Similar to Jump Game II. We want to pick the clip that extends our coverage
     * the furthest in each step.
     * 1. Track the farthest reachable point for each start point (prev_max_reach).
     * 2. Iterate and update the global max reach from all clips covering the
     * current point.
     * 3. When we reach the end of our current coverage, increment count and update
     * coverage to the global max reach.
     * 
     * Why Optimal:
     * By always picking the clip that provides the maximum reach for the next step,
     * we minimize the total clips required.
     * 
     * Time Complexity: O(time + n) or O(n log n) with sorting.
     * Space Complexity: O(time) for mapping start to max_end.
     */
    public static int videoStitching(int[][] clips, int time) {
        // Find max end for each possible start time
        int[] maxReachAtStart = new int[101];
        for (int[] clip : clips) {
            if (clip[0] < 101) {
                maxReachAtStart[clip[0]] = Math.max(maxReachAtStart[clip[0]], clip[1]);
            }
        }

        int count = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < time; i++) {
            farthest = Math.max(farthest, maxReachAtStart[i]);

            // If we are stuck
            if (i == farthest)
                return -1;

            // If we reached the end of current clip's coverage
            if (i == currentEnd) {
                count++;
                currentEnd = farthest;
                if (currentEnd >= time)
                    break;
            }
        }

        return (currentEnd >= time) ? count : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of clips:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        int[][] clips = new int[n][2];
        System.out.println("Enter start and end for each clip:");
        for (int i = 0; i < n; i++) {
            clips[i][0] = sc.nextInt();
            clips[i][1] = sc.nextInt();
        }

        System.out.println("Enter target time:");
        int time = sc.nextInt();

        System.out.println("Minimum clips required: " + videoStitching(clips, time));
        sc.close();
    }
}
