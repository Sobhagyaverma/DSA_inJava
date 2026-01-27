import java.util.*;

/**
 * Problem 8: Search in Rotated Sorted Array
 * 
 * Input Format:
 * n, then n rotated sorted integers, then target.
 * 
 * Output Format:
 * Index of target or -1.
 * 
 * Approach: Binary Search
 * Time Complexity: O(log n).
 * Space Complexity: O(1).
 * Why Optimal: Binary search works on rotated arrays by identifying which half
 * is sorted.
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter rotated sorted integers:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        System.out.print("Enter target: ");
        int target = sc.nextInt();

        System.out.println("Target index: " + search(nums, target));
        sc.close();
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;

            // Check if left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
