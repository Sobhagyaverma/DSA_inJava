import java.util.*;

/**
 * Problem 23: Decode Ways
 * 
 * Input Format:
 * A string of digits.
 * 
 * Output Format:
 * Number of ways to decode it (A=1, B=2 ... Z=26).
 * 
 * Approach:
 * Recursion with memoization.
 * Check 1-digit and 2-digit combinations.
 */
public class DecodeWays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter digits: ");
        String s = sc.nextLine();

        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);

        System.out.println("Number of ways to decode: " + decode(s, 0, memo));
        sc.close();
    }

    private static int decode(String s, int index, int[] memo) {
        // Base case: end of string reached
        if (index == s.length())
            return 1;

        // Leading zero cannot be decoded
        if (s.charAt(index) == '0')
            return 0;

        if (memo[index] != -1)
            return memo[index];

        // Case 1: Decode single digit
        int ways = decode(s, index + 1, memo);

        // Case 2: Decode two digits (if <= 26)
        if (index + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigit <= 26) {
                ways += decode(s, index + 2, memo);
            }
        }

        return memo[index] = ways;
    }
}
