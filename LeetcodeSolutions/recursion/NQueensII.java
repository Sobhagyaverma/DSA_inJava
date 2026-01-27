import java.util.*;

/**
 * Problem 18: N-Queens II
 * 
 * Input Format:
 * Integer n.
 * 
 * Output Format:
 * Total number of distinct solutions.
 * 
 * Approach:
 * Backtracking optimized with boolean arrays for column and diagonal
 * constraints.
 */
public class NQueensII {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // r + c
        boolean[] diag2 = new boolean[2 * n]; // r - c + n

        solve(n, 0, cols, diag1, diag2);

        System.out.println("Total solutions for " + n + "-Queens: " + count);
        sc.close();
    }

    private static void solve(int n, int row, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + n;

            if (!cols[col] && !diag1[d1] && !diag2[d2]) {
                cols[col] = diag1[d1] = diag2[d2] = true;
                solve(n, row + 1, cols, diag1, diag2);
                cols[col] = diag1[d1] = diag2[d2] = false;
            }
        }
    }
}
