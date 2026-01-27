import java.util.*;

/**
 * Problem 25: Restore IP Addresses
 * 
 * Input Format:
 * A string of digits.
 * 
 * Output Format:
 * All possible valid IP addresses.
 * 
 * Approach:
 * Backtracking to split string into 4 parts, each 1-3 digits long and <= 255.
 */
public class RestoreIPAddresses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter digits: ");
        String s = sc.nextLine();

        List<String> res = new ArrayList<>();
        backtrack(s, 0, 0, "", res);

        System.out.println("Valid IP Addresses: " + res);
        sc.close();
    }

    private static void backtrack(String s, int index, int count, String current, List<String> res) {
        // Base case: 4 parts found
        if (count == 4) {
            if (index == s.length())
                res.add(current.substring(0, current.length() - 1));
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length())
                break;

            String part = s.substring(index, index + len);

            // Validate part: no leading zeroes (except "0"), value <= 255
            if ((part.startsWith("0") && part.length() > 1) || Integer.parseInt(part) > 255)
                continue;

            backtrack(s, index + len, count + 1, current + part + ".", res);
        }
    }
}
