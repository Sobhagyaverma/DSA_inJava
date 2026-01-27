import java.util.*;

/**
 * Problem 8: Permutations
 * 
 * Input Format:
 * Space-separated integers.
 * 
 * Output Format:
 * List of all permutations.
 * 
 * Approach:
 * Backtracking by swapping elements or using a boolean array to track used
 * elements.
 */
public class Permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numbers space-separated: ");
        String line = sc.nextLine();
        if (line.trim().isEmpty()) {
            System.out.println("[]");
            sc.close();
            return;
        }
        String[] parts = line.split("\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);

        System.out.println("Permutations: " + result);
        sc.close();
    }

    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] used) {
        // Base case: current list size equals input array size
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            // Choose
            used[i] = true;
            current.add(nums[i]);

            // Recurse
            backtrack(nums, current, result, used);

            // Backtrack
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
