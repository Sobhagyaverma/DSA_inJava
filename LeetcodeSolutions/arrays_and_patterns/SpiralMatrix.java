import java.util.*;

/**
 * Problem 23: Spiral Matrix
 * 
 * Input Format:
 * Rows m, Columns n, then matrix elements.
 * 
 * Output Format:
 * Elements in spiral order.
 * 
 * Approach: Boundary Traversal (Simulation)
 * Time Complexity: O(m * n).
 * Space Complexity: O(1) (excluding output list).
 * Why Optimal: Visits each element exactly once in the correct order using 4
 * boundary variables.
 */
public class SpiralMatrix {
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

        System.out.println("Spiral Order: " + spiralOrder(matrix));
        sc.close();
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0)
            return res;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;

        while (r1 <= r2 && c1 <= c2) {
            // Right
            for (int c = c1; c <= c2; c++)
                res.add(matrix[r1][c]);
            // Down
            for (int r = r1 + 1; r <= r2; r++)
                res.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                // Left
                for (int c = c2 - 1; c >= c1; c--)
                    res.add(matrix[r2][c]);
                // Up
                for (int r = r2 - 1; r > r1; r--)
                    res.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return res;
    }
}
