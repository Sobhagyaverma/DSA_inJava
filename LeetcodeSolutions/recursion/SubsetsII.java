import java.util.*;

/**
 * Problem 7: Subsets II (with duplicates)
 * 
 * Input Format:
 * Space-separated integers (may contain duplicates).
 * 
 * Output Format:
 * List of unique subsets.
 * 
 * Approach:
 * Backtracking with sorting and skipping duplicates.
 */
public class SubsetsII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter elements (with potential duplicates) space-separated: ");
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

        // Must sort to handle duplicates
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), result);

        System.out.println("Unique Subsets: " + result);
        sc.close();
    }

    private static void generateSubsets(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Optimization: Skip duplicates in the current level of recursion
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);
            generateSubsets(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
