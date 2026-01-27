import java.util.*;

/**
 * Problem 22: Flatten a Nested List
 * 
 * Input Format:
 * This implementation uses a recursive list structure.
 * Example simulation: [[1,1],2,[1,1]]
 * 
 * Output Format:
 * A single flattened list: [1,1,2,1,1]
 * 
 * Approach:
 * Recursive traversal of nested lists.
 */
public class FlattenNestedList {
    public static void main(String[] args) {
        // Simulated input: [[1,1],2,[1,1]]
        // Since parsing complex JSON-like nested lists with Scanner is tedious,
        // we demonstrate the logic with a hardcoded structure or simple input.
        List<Object> nestedList = new ArrayList<>();
        nestedList.add(Arrays.asList(1, 1));
        nestedList.add(2);
        nestedList.add(Arrays.asList(1, 1));

        List<Integer> result = new ArrayList<>();
        flatten(nestedList, result);

        System.out.println("Nested List: [[1,1],2,[1,1]]");
        System.out.println("Flattened List: " + result);
    }

    private static void flatten(List<Object> list, List<Integer> result) {
        for (Object obj : list) {
            if (obj instanceof Integer) {
                result.add((Integer) obj);
            } else if (obj instanceof List) {
                flatten((List<Object>) obj, result);
            }
        }
    }
}
