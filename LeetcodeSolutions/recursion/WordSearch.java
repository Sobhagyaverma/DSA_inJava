import java.util.*;

/**
 * Problem 15: Word Search
 * 
 * Input Format:
 * Dimensions (m n), then m lines of n characters, then the target word.
 * 
 * Output Format:
 * Boolean (true/false) if word exists in grid.
 * 
 * Approach:
 * DFS with backtracking. Mark visited cells temporarily in the grid to avoid
 * reuse.
 */
public class WordSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and columns (m n): ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] board = new char[m][n];
        System.out.println("Enter grid characters:");
        for (int i = 0; i < m; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = row.charAt(j);
            }
        }
        System.out.print("Enter target word: ");
        String word = sc.next();

        boolean exists = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    exists = true;
                    break;
                }
            }
            if (exists)
                break;
        }

        System.out.println("Word exists: " + exists);
        sc.close();
    }

    private static boolean dfs(char[][] board, String word, int r, int c, int k) {
        // Base case: all characters matched
        if (k == word.length())
            return true;

        // Boundary and character match check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(k)) {
            return false;
        }

        // Action: Mark as visited
        char temp = board[r][c];
        board[r][c] = '#';

        // Recurse in 4 directions
        boolean found = dfs(board, word, r + 1, c, k + 1) ||
                dfs(board, word, r - 1, c, k + 1) ||
                dfs(board, word, r, c + 1, k + 1) ||
                dfs(board, word, r, c - 1, k + 1);

        // Backtrack
        board[r][c] = temp;
        return found;
    }
}
