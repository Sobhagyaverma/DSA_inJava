import java.util.*;

/**
 * Problem 21: Search a 2D Matrix
 * 
 * Input Format:
 * Rows m, Columns n, then m*n matrix elements, then target.
 * 
 * Output Format:
 * Boolean (true/false) if target exists.
 * 
 * Approach: Binary Search (treating 2D as 1D)
 * Time Complexity: O(log(m * n)).
 * Space Complexity: O(1).
 * Why Optimal: The matrix is sorted across rows and columns.
 */
public class SearchA2DMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and columns (m n): ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }
        System.out.print("Enter target: ");
        int target = sc.nextInt();

        System.out.println("Target found: " + searchMatrix(matrix, target));
        sc.close();
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = matrix[mid / n][mid % n];
            if (val == target)
                return true;
            if (val < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
