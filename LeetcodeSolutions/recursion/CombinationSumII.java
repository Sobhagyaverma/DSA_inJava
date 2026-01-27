import java.util.*;

/**
 * Problem 13: Combination Sum II
 * 
 * Input Format:
 * Space-separated target followed by array elements.
 * 
 * Output Format:
 * Unique combinations where each number is used once.
 * 
 * Approach:
 * Backtracking with sorting and duplicates check.
 */
public class CombinationSumII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter target followed by array elements: ");
        int target = sc.nextInt();
        String line = sc.nextLine(); // consume
        line = sc.nextLine();
        String[] parts = line.split("\s+");
        int[] candidates = new int[parts.length];
        for (int i = 0; i < parts.length; i++)
            candidates[i] = Integer.parseInt(parts[i]);

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);

        System.out.println("Unique Combinations: " + result);
        sc.close();
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> current,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0)
            return;

        for (int i = start; i < candidates.length; i++) {
            // Optimization: Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1])
                continue;

            current.add(candidates[i]);
            // Recurse: i+1 passed because we can't reuse the same index
            backtrack(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
