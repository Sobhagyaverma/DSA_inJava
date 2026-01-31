package greedy_backtracking;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

/*
Problem Statement:
There are some spherical balloons taped onto a flat wall that represents the XY-plane. 
The balloons are represented as a 2D integer array points where points[i] = [start, end] 
denote a balloon whose horizontal diameter stretches between start and end. 
You do not know the exact y-coordinates of the balloons.
Arrows can be shot up vertically (in the positive y-direction) from different points 
along the x-axis. A balloon with [start, end] is burst by an arrow shot at x if start <= x <= end. 
An arrow can be shot up exactly once but can burst any number of balloons.
Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

Input Format:
- n (number of balloons)
- n pairs of integers (start, end)

Output Format:
- Minimum number of arrows

Constraints:
1 <= points.length <= 10^5
points[i].length == 2
-2^31 <= start < end <= 2^31 - 1

Sample Input:
4
10 16
2 8
1 6
7 12
Sample Output:
2
*/

public class MinArrowsBurstBalloons {
    /**
     * Greedy Choice:
     * Sort the balloons based on their end coordinates. We shoot the first arrow at
     * the end of the first balloon. For subsequent balloons, if their start point
     * is already within the range covered by the previous arrow (i.e., start <=
     * prevEnd),
     * they are burst. If not, we need a new arrow and reset our arrow position
     * to the current balloon's end.
     * 
     * Why Optimal:
     * By shooting at the earliest possible end point, we maximize the chances of
     * catching other balloons that start before or at that x-coordinate but
     * end later.
     * 
     * Time Complexity: O(n log n) - primarily due to sorting.
     * Space Complexity: O(1) or O(log n) depending on sort implementation.
     */
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;

        // Sort by ending coordinates
        // Use Integer.compare to avoid overflow with (a[1] - b[1])
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrows = 1;
        int prevEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // If current balloon starts AFTER the last arrow position
            if (points[i][0] > prevEnd) {
                arrows++;
                prevEnd = points[i][1]; // Move arrow position to current end
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of balloons:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        int[][] points = new int[n][2];
        System.out.println("Enter start and end points for each balloon:");
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        System.out.println("Minimum arrows needed: " + findMinArrowShots(points));
        sc.close();
    }
}
