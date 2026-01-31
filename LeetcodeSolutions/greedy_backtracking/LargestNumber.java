package greedy_backtracking;

import java.util.Arrays;
import java.util.Scanner;

/*
Problem Statement:
Given a list of non-negative integers nums, arrange them such that they form the largest number 
and return it as a string. Since the result may be very large, return a string instead of an integer.

Input Format:
- n (size of array)
- n non-negative integers

Output Format:
- String representing the largest number

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 10^9

Sample Input:
5
3 30 34 5 9
Sample Output:
"9534330"
*/

public class LargestNumber {
    /**
     * Greedy Choice:
     * When comparing two numbers (as strings) a and b, the greedy choice is to pick
     * the order (a+b) or (b+a) that produces a larger numeric result.
     * We sort the entire array with this custom comparison rule.
     * 
     * Why Optimal:
     * This comparison rule satisfies the transitive property. If order(A,B) >=
     * order(B,A)
     * and order(B,C) >= order(C,B), then order(A,C) >= order(C,A).
     * Thus, placing the 'best' elements first locally leads to the global maximum.
     * 
     * Time Complexity: O(n log n) - Sorting strings with custom comparator.
     * Space Complexity: O(n) - To store string representation of numbers.
     */
    public static String largestNumber(int[] nums) {
        // Convert to Strings
        String[] sNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sNums[i] = String.valueOf(nums[i]);
        }

        // Custom Sort: (b+a) compared to (a+b) for descending order
        Arrays.sort(sNums, (a, b) -> (b + a).compareTo(a + b));

        // Edge Case: If the largest number is "0", result is just "0"
        if (sNums[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : sNums) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter non-negative integers:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Largest possible number: " + largestNumber(nums));
        sc.close();
    }
}
