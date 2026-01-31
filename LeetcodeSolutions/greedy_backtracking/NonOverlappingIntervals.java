package greedy_backtracking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
Problem Statement:
Given an array of intervals intervals where intervals[i] = [starti, endi], 
return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Input Format:
- n (number of intervals)
- n pairs of integers (start, end)

Output Format:
- Minimum number of intervals to remove

Constraints:
1 <= intervals.length <= 10^5
intervals[i].length == 2
-5 * 10^4 <= starti < endi <= 5 * 10^4

Sample Input:
4
1 2
2 3
3 4
1 3
Sample Output:
1 (remove [1, 3])
*/

public class NonOverlappingIntervals {
    /**
     * Greedy Choice:
     * To keep the maximum number of non-overlapping intervals, we should always
     * pick the
     * interval that ends earliest. This leaves the most room for remaining
     * intervals.
     * 1. Sort intervals by end time.
     * 2. Iterate and count how many intervals we can 'keep'.
     * 3. Result = Total - Kept.
     * 
     * Why Optimal:
     * Choosing the interval with symbols that end first ensures the maximum
     * remaining x-axis
     * space for adding further intervals.
     * 
     * Time Complexity: O(n log n) - Sorting.
     * Space Complexity: O(1) or O(log n) depending on sorting.
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        // Sort by end time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 1; // Number of non-overlapping intervals kept
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // If current interval starts at or after the previous ends, we can keep it
            if (intervals[i][0] >= prevEnd) {
                count++;
                prevEnd = intervals[i][1];
            }
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of intervals:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        int[][] intervals = new int[n][2];
        System.out.println("Enter start and end for each interval:");
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        System.out.println("Minimum intervals to remove: " + eraseOverlapIntervals(intervals));
        sc.close();
    }
}
