package greedy_backtracking;

import java.util.Arrays;
import java.util.Scanner;

/*
Problem Statement:
Assume you are a parent and want to give your children some cookies. 
But, you should give each child at most one cookie.
Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will 
be content with; and each cookie j has a size s[j]. If s[j] >= g[i], 
we can assign the cookie j to the child i, and the child i will be content. 
Your goal is to maximize the number of your content children and output the maximum number.

Input Format:
- nG (number of children)
- nG integers (greed factors)
- nS (number of cookies)
- nS integers (cookie sizes)

Output Format:
- Maximum content children

Constraints:
1 <= g.length <= 3 * 10^4
0 <= s.length <= 3 * 10^4
1 <= g[i], s[j] <= 2^31 - 1

Sample Input:
2
1 2
3
1 2 3
Sample Output:
2
*/

public class AssignCookies {
    /**
     * Greedy Choice:
     * To satisfy the maximum number of children, we should use the smallest cookie
     * possible
     * to satisfy the child with the smallest greed factor first.
     * 1. Sort children's greed factors.
     * 2. Sort available cookie sizes.
     * 3. Iterate through cookies and check if the current cookie satisfies the
     * current hungriest child.
     * 
     * Why Optimal:
     * If we use a large cookie to satisfy a child who could be satisfied by a
     * smaller cookie,
     * we are wasting potential satisfaction for children with higher greed factors.
     * 
     * Time Complexity: O(n log n + m log m) where n is g.length and m is s.length.
     * Space Complexity: O(1) or O(log n + log m).
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int childIndex = 0;
        int cookieIndex = 0;

        while (childIndex < g.length && cookieIndex < s.length) {
            // Greedy: If the current cookie can satisfy the current child
            if (s[cookieIndex] >= g[childIndex]) {
                childIndex++; // Move to next child
            }
            cookieIndex++; // Always move to next cookie
        }

        return childIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of children:");
        if (!sc.hasNextInt())
            return;
        int nG = sc.nextInt();
        int[] g = new int[nG];
        System.out.println("Enter greed factors:");
        for (int i = 0; i < nG; i++)
            g[i] = sc.nextInt();

        System.out.println("Enter number of cookies:");
        int nS = sc.nextInt();
        int[] s = new int[nS];
        System.out.println("Enter cookie sizes:");
        for (int i = 0; i < nS; i++)
            s[i] = sc.nextInt();

        System.out.println("Maximum content children: " + findContentChildren(g, s));
        sc.close();
    }
}
