import java.util.*;

/**
 * Problem 25: Insert Interval
 * 
 * Input Format:
 * Number of intervals n, n intervals, then new interval (start end).
 * 
 * Output Format:
 * Updated intervals list.
 * 
 * Approach: Linear Scan
 * Time Complexity: O(n).
 * Space Complexity: O(n) for result list.
 * Why Optimal: The intervals are already sorted. We only need one pass to find
 * the insertion spot and merge.
 */
public class InsertInterval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        System.out.println("Enter intervals:");
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        System.out.print("Enter new interval (start end): ");
        int[] newInterval = new int[] { sc.nextInt(), sc.nextInt() };

        int[][] result = insert(intervals, newInterval);
        System.out.print("Updated Intervals: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(Arrays.toString(result[i]) + (i < result.length - 1 ? ", " : ""));
        }
        System.out.println("]");
        sc.close();
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1. Add all before new
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }

        // 2. Merge overlapping
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // 3. Add remaining
        while (i < n) {
            res.add(intervals[i++]);
        }

        return res.toArray(new int[res.size()][2]);
    }
}
