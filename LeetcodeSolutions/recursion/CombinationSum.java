import java.util.*;

/**
 * Problem 12: Combination Sum
 * 
 * Input Format:
 * Space-separated target and then space-separated array elements.
 * Example: 7 2 3 6 7
 * 
 * Output Format:
 * List of combinations that sum to target.
 * 
 * Approach:
 * Backtracking allowing unlimited use of same element.
 */
public class CombinationSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter target followed by array elements: ");
        int target = sc.nextInt();
        String line = sc.nextLine(); // consume newline
        line = sc.nextLine();
        String[] parts = line.split("\s+");
        int[] candidates = new int[parts.length];
        for (int i = 0; i < parts.length; i++)
            candidates[i] = Integer.parseInt(parts[i]);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);

        System.out.println("Combinations: " + result);
        sc.close();
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> current,
            List<List<Integer>> result) {
        // Base case: target met
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        // Base case: target exceeded (Pruning)
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            // Recurse: i is passed (not i+1) because we can reuse the same element
            backtrack(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
