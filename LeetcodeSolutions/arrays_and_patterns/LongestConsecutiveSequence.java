import java.util.*;

/**
 * Problem 17: Longest Consecutive Sequence
 * 
 * Input Format:
 * n, then n integers.
 * 
 * Output Format:
 * Length of the longest consecutive elements sequence.
 * 
 * Approach: Hashing (HashSet)
 * Time Complexity: O(n) - Each element is visited at most twice.
 * Space Complexity: O(n).
 * Why Optimal: Efficiently identifies start of a sequence (x-1 not in set) and
 * expands linearly.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println("Longest Sequence Length: " + longestConsecutive(nums));
        sc.close();
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);

        int maxLen = 0;
        for (int n : set) {
            // Check if it's the start of a sequence
            if (!set.contains(n - 1)) {
                int curr = n;
                int len = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
