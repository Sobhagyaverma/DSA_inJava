package greedy_backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Problem Statement:
Given a string containing digits from 2-9 inclusive, return all possible letter 
combinations that the number could represent. Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) is given below. 
Note that 1 does not map to any letters.
Mapping:
2: abc, 3: def, 4: ghi, 5: jkl, 6: mno, 7: pqrs, 8: tuv, 9: wxyz

Input Format:
- A string of digits (2-9)

Output Format:
- List of combined strings

Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].

Sample Input:
"23"
Sample Output:
["ad","ae","af","bd","be","bf","cd","ce","cf"]
*/

public class LetterCombinations {
    /**
     * Backtracking Approach:
     * We iterate through the digits string. For each digit, we look up its mapped
     * letters. We try each letter and recursively proceed to the next digit.
     * 
     * Choice: Pick one letter from the current digit's mapping.
     * Recursive Call: Move to the next digit in the string.
     * Backtrack: Undo the character addition from the result builder.
     * 
     * Time Complexity: O(3^N * 4^M) where N is digits with 3 letters and M is
     * digits with 4 letters.
     * Space Complexity: O(N + M) - Recursion depth equals digits length.
     */
    private static final String[] MAPPING = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        // Base case
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = MAPPING[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            // Choice
            current.append(c);

            // Recursive Call
            backtrack(result, current, digits, index + 1);

            // Backtrack
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter digits (2-9):");
        if (!sc.hasNext())
            return;
        String digits = sc.next();

        LetterCombinations obj = new LetterCombinations();
        List<String> result = obj.letterCombinations(digits);

        System.out.println("Combinations:");
        System.out.println(result);

        sc.close();
    }
}
