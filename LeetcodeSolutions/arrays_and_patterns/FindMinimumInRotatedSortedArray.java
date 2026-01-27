import java.util.*;

/**
 * Problem 7: Find Minimum in Rotated Sorted Array
 * 
 * Input Format:
 * Number of elements n, then n rotated sorted integers.
 * 
 * Output Format:
 * Minimum element.
 * 
 * Approach: Binary Search
 * Time Complexity: O(log n) - Search space is halved each step.
 * Space Complexity: O(1).
 * Why Optimal: Leveraging the sorted nature (even if rotated) to achieve
 * logarithmic time.
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter rotated sorted integers:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println("Minimum element: " + findMin(nums));
        sc.close();
    }

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                // Min is in the right half
                left = mid + 1;
            } else {
                // Min is mid or in the left half
                right = mid;
            }
        }
        return nums[left];
    }
}
