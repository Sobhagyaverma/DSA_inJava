import java.util.*;

/**
 * Problem 9: Permutations II (with duplicates)
 * 
 * Input Format:
 * Space-separated integers (may contain duplicates).
 * 
 * Output Format:
 * List of unique permutations.
 * 
 * Approach:
 * Backtracking with sorting and duplicates checking.
 */
public class PermutationsII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numbers (with duplicates) space-separated: ");
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

        Arrays.sort(nums); // Critical for duplicate handling

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);

        System.out.println("Unique Permutations: " + result);
        sc.close();
    }

    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            // Optimization: Skip duplicates
            // !used[i-1] means nums[i-1] was used and then backtracked at the same level
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, current, result, used);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
