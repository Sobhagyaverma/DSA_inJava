import java.util.*;

/**
 * Problem 24: Word Search
 * 
 * Input Format:
 * m n, matrix characters, target word.
 * 
 * Output Format:
 * Boolean if word found.
 * 
 * Approach: DFS with Backtracking
 * Time Complexity: O(m * n * 4^L) where L is word length.
 * Space Complexity: O(L) for recursion depth.
 * Why Optimal: Efficiently explores potential paths with pruning.
 */
public class WordSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter m n: ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] board = new char[m][n];
        System.out.println("Enter matrix characters (row by row):");
        for (int i = 0; i < m; i++) {
            String word = sc.next();
            for (int j = 0; j < n; j++)
                board[i][j] = word.charAt(j);
        }
        System.out.print("Enter target word: ");
        String target = sc.next();

        System.out.println("Word exists: " + exist(board, target));
        sc.close();
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int r, int c, String word, int k) {
        if (k == word.length())
            return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(k))
            return false;

        char temp = board[r][c];
        board[r][c] = '#'; // Mark visited
        boolean found = dfs(board, r + 1, c, word, k + 1) ||
                dfs(board, r - 1, c, word, k + 1) ||
                dfs(board, r, c + 1, word, k + 1) ||
                dfs(board, r, c - 1, word, k + 1);
        board[r][c] = temp; // Backtrack
        return found;
    }
}
