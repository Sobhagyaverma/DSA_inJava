import java.util.Scanner;

/**
 * Problem 5: Print All Subsequences of a String
 * 
 * Input Format:
 * A single string.
 * 
 * Output Format:
 * All subsequences of the string printed line by line.
 * 
 * Approach:
 * Using recursion with a "Pick or Don't Pick" strategy for each character.
 */
public class PrintAllSubsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        System.out.println("Subsequences:");
        printSubsequences(s, 0, "");
        sc.close();
    }

    /**
     * Recursive function to generate subsequences.
     * 
     * @param s       Original string
     * @param index   Current character index being considered
     * @param current Current subsequence being formed
     */
    public static void printSubsequences(String s, int index, String current) {
        // Base case: if we have processed all characters
        if (index == s.length()) {
            if (current.isEmpty()) {
                System.out.println("(empty)");
            } else {
                System.out.println(current);
            }
            return;
        }

        // Option 1: Pick the current character
        printSubsequences(s, index + 1, current + s.charAt(index));

        // Option 2: Don't pick the current character
        printSubsequences(s, index + 1, current);
    }
}
