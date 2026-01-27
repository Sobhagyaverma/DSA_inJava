import java.util.*;

/**
 * Problem 9: 3Sum
 * 
 * Input Format:
 * n, then n integers.
 * 
 * Output Format:
 * Unique triplets that sum to zero.
 * 
 * Approach: Sort + Two Pointers
 * Time Complexity: O(n^2) - One loop for the first element, two pointers for
 * the rest.
 * Space Complexity: O(log n) or O(n) depending on sort implementation.
 * Why Optimal: The most efficient way to find unique triplets without nested
 * O(n^3) or high space hashing.
 */
public class ThreeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        List<List<Integer>> triplets = threeSum(nums);
        System.out.println("Triplets: " + triplets);
        sc.close();
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // Skip duplicates for i

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1])
                        left++; // skip duplicates for left
                    while (left < right && nums[right] == nums[right - 1])
                        right--; // skip duplicates for right
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
