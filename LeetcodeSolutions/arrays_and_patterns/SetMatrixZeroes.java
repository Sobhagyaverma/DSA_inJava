import java.util.*;

/**
 * Problem 22: Set Matrix Zeroes
 * 
 * Input Format:
 * Rows m, Columns n, then m*n matrix elements.
 * 
 * Output Format:
 * Modified matrix with rows and cols zeroed if original was zero.
 * 
 * Approach: Optimized Space (using first row and col as markers)
 * Time Complexity: O(m * n).
 * Space Complexity: O(1) - Marker variables instead of extra matrices.
 * Why Optimal: Accomplishes the task without O(m+n) or O(m*n) extra space.
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter m n: ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        System.out.println("Enter elements:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }

        setZeroes(matrix);
        System.out.println("Resulting Matrix:");
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
        sc.close();
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;

        // Check if first row/col should be zeroed
        for (int i = 0; i < m; i++)
            if (matrix[i][0] == 0)
                firstColZero = true;
        for (int j = 0; j < n; j++)
            if (matrix[0][j] == 0)
                firstRowZero = true;

        // Use first row/col as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Zero out interior based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        // Zero out first row/col if needed
        if (firstColZero)
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
        if (firstRowZero)
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
    }
}
