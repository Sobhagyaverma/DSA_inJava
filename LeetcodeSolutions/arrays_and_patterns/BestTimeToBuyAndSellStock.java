import java.util.*;

/**
 * Problem 2: Best Time to Buy and Sell Stock
 * 
 * Input Format:
 * Number of days n, then n prices.
 * 
 * Output Format:
 * Maximum profit possible.
 * 
 * Approach: One Pass (Greedy/Min So Far)
 * Time Complexity: O(n) - Linear scan.
 * Space Complexity: O(1) - Constant space for variables.
 * Why Optimal: We only care about the minimum price seen so far to calculate
 * potential profit at each step.
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("Max Profit: 0");
            sc.close();
            return;
        }
        int[] prices = new int[n];
        System.out.println("Enter prices:");
        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        System.out.println("Max Profit: " + maxProfit(prices));
        sc.close();
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
