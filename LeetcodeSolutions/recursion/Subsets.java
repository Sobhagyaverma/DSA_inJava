import java.util.*;

/**
 * Problem 6: Subsets
 * 
 * Input Format:
 * Space-separated integers representing the array.
 * 
 * Output Format:
 * List of all possible subsets (the power set).
 * 
 * Approach:
 * Backtracking (Depth First Search). At each step, we have the choice to
 * include a number or not.
 */
public class Subsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter elements of array separated by space: ");
        String line = sc.nextLine();
        if (line.trim().isEmpty()) {
            System.out.println("[[]]");
            sc.close();
            return;
        }
        String[] parts = line.split("\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), result);

        System.out.println("Subsets: " + result);
        sc.close();
    }

    private static void generateSubsets(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // Every state is a valid subset
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Include nums[i]
            current.add(nums[i]);
            // Recurse for remaining elements
            generateSubsets(nums, i + 1, current, result);
            // Backtrack: Remove nums[i]
            current.remove(current.size() - 1);
        }
    }
}
