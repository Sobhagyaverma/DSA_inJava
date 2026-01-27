import java.util.*;

/**
 * Problem 20: Merge Intervals
 * 
 * Input Format:
 * Number of intervals n, then n pairs of (start end).
 * 
 * Output Format:
 * List of merged intervals.
 * 
 * Approach: Sorting + Linear Scan
 * Time Complexity: O(n log n) - Due to sorting.
 * Space Complexity: O(log n) or O(n) for sorting storage.
 * Why Optimal: Sorting ensures overlapping candidates are adjacent.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of intervals: ");
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        System.out.println("Enter intervals (start end):");
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        int[][] result = merge(intervals);
        System.out.print("Merged Intervals: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(Arrays.toString(result[i]) + (i < result.length - 1 ? ", " : ""));
        }
        System.out.println("]");
        sc.close();
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        merged.add(current);

        for (int[] next : intervals) {
            if (next[0] <= current[1]) {
                // Overlap: update end time
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap: add new interval
                current = next;
                merged.add(current);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
