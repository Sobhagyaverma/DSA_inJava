import java.util.*;

/**
 * Problem 10: Letter Combinations of a Phone Number
 * 
 * Input Format:
 * A string of digits (2-9).
 * 
 * Output Format:
 * List of all possible letter combinations.
 * 
 * Approach:
 * Backtracking using a mapping of digits to letters.
 */
public class LetterCombinationsPhoneNumber {
    private static final String[] MAPPING = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter digits (2-9): ");
        String digits = sc.nextLine();

        if (digits.isEmpty()) {
            System.out.println("Result: []");
        } else {
            List<String> result = new ArrayList<>();
            backtrack(digits, 0, new StringBuilder(), result);
            System.out.println("Combinations: " + result);
        }
        sc.close();
    }

    private static void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // Base case
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = MAPPING[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
