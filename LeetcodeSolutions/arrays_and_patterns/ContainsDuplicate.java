import java.util.*;

/**
 * Problem 3: Contains Duplicate
 * 
 * Input Format:
 * Number of elements n, then n integers.
 * 
 * Output Format:
 * Boolean (true/false).
 * 
 * Approach: Hashing (HashSet)
 * Time Complexity: O(n) - Single pass.
 * Space Complexity: O(n) - To store elements in HashSet.
 * Why Optimal: Average case lookup and insertion in HashSet is O(1).
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println("Contains Duplicate: " + containsDuplicate(nums));
        sc.close();
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num))
                return true;
            seen.add(num);
        }
        return false;
    }
}
