import java.util.*;

/**
 * Problem 18: Sliding Window Maximum
 * 
 * Input Format:
 * n, then n integers, then window size k.
 * 
 * Output Format:
 * Array of maximum values in each sliding window.
 * 
 * Approach: Monotonic Deque
 * Time Complexity: O(n) - Each element is added/removed once.
 * Space Complexity: O(k) - Deque stores indices of elements in window.
 * Why Optimal: Efficiently keeps track of relevant maximums in O(1) amortized
 * time per window slide.
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        System.out.print("Enter window size k: ");
        int k = sc.nextInt();

        int[] result = maxSlidingWindow(nums, k);
        System.out.println("Window Maximums: " + Arrays.toString(result));
        sc.close();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0)
            return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>(); // Stores indices

        for (int i = 0; i < n; i++) {
            // Remove indices out of window
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            // Remove indices of smaller elements
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            // Result if window is full
            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
