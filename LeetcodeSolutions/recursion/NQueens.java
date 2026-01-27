import java.util.*;

/**
 * Problem 17: N-Queens
 * 
 * Input Format:
 * Integer n (number of queens and grid size).
 * 
 * Output Format:
 * All distinct solutions to the n-queens puzzle.
 * 
 * Approach:
 * Backtracking with row, column, and diagonal constraint checks.
 */
public class NQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        List<List<String>> result = new ArrayList<>();
        solve(board, 0, result);

        System.out.println("Solutions found: " + result.size());
        for (List<String> sol : result) {
            for (String row : sol)
                System.out.println(row);
            System.out.println();
        }
        sc.close();
    }

    private static void solve(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                solve(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isValid(char[][] board, int row, int col) {
        // Vertical check
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q')
                return false;

        // Diagonal \ check
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        // Diagonal / check
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++)
            res.add(new String(board[i]));
        return res;
    }
}
