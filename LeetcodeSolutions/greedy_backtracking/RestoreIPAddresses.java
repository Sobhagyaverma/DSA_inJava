package greedy_backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Problem Statement:
A valid IP address consists of exactly four integers separated by single dots. 
Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, 
but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid.
Given a string s containing only digits, return all possible valid IP addresses 
that can be formed by inserting dots into s.

Input Format:
- A string of digits s

Output Format:
- List of valid IP addresses

Constraints:
1 <= s.length <= 20
s consists of digits only.

Sample Input:
"25525511135"
Sample Output:
["255.255.11.135","255.255.111.35"]
*/

public class RestoreIPAddresses {
    /**
     * Backtracking Approach:
     * We slice the string into 4 segments. For each segment, we try lengths 1, 2,
     * and 3.
     * We validate each segment based on IP rules.
     * 
     * Choice: Take a segment of length 1, 2, or 3.
     * Recursive Call: Call for the remaining string and increment segment count.
     * Backtrack: The segment removal is handled by the loop and substring logic in
     * Java.
     * 
     * Time Complexity: O(3^4) - Since depth is 4 and max choices are 3. Constant
     * time essentially.
     * Space Complexity: O(1) - Final output list not counted.
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", s, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, String currentPath, String s, int index, int dots) {
        // Base case: 4 segments found
        if (dots == 4) {
            if (index == s.length()) {
                result.add(currentPath.substring(0, currentPath.length() - 1));
            }
            return;
        }

        // Segment length can be 1, 2, or 3
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length())
                break;

            String segment = s.substring(index, index + len);

            // Pruning: Check validity
            // 1. Value must be <= 255
            // 2. No leading zeros (unless the segment is just "0")
            if (isValid(segment)) {
                backtrack(result, currentPath + segment + ".", s, index + len, dots + 1);
            }
        }
    }

    private boolean isValid(String s) {
        if (s.startsWith("0") && s.length() > 1)
            return false;
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter digit string:");
        if (!sc.hasNext())
            return;
        String s = sc.next();

        RestoreIPAddresses obj = new RestoreIPAddresses();
        List<String> results = obj.restoreIpAddresses(s);

        System.out.println("Possible IP addresses:");
        System.out.println(results);

        sc.close();
    }
}
