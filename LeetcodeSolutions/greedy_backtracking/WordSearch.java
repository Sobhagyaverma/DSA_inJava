package greedy_backtracking;

import java.util.Scanner;

/*
Problem Statement:
Given an m x n grid of characters board and a string word, return true if word 
exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where 
adjacent cells are horizontally or vertically neighboring. The same letter 
cell may not be used more than once.

Input Format:
- m, n (dimensions)
- m*n grid of chars
- word string

Output Format:
- Boolean (true/false)

Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.

Sample Input:
3 4
A B C E
S F C S
A D E E
ABCCED
Sample Output:
true
*/

public class WordSearch {
    /**
     * Backtracking Approach (DFS):
     * We start a DFS from every cell in the board. In DFS, we move in 4 directions
     * to find the next character of the word.
     * 
     * Choice: Move to an adjacent cell (up, down, left, right).
     * Recursive Call: Call for the next character index in the word.
     * Backtrack: Restore the cell value (visited mark) to its original character.
     * Pruning: Stop if indices are out of bounds or characters don't match.
     * 
     * Time Complexity: O(M * N * 3^L) where L is word length.
     * Space Complexity: O(L) - Recursion depth.
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If start character matches, trigger DFS
                if (dfs(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        // Base case: word found
        if (index == word.length())
            return true;

        // Pruning: boundaries and character match
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        // Choice: Mark as visited (using a temporary character)
        char temp = board[r][c];
        board[r][c] = '#';

        // Recursive Calls: 4 directions
        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                dfs(board, word, r - 1, c, index + 1) ||
                dfs(board, word, r, c + 1, index + 1) ||
                dfs(board, word, r, c - 1, index + 1);

        // Backtrack: restore character
        board[r][c] = temp;

        return found;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimensions m and n:");
        if (!sc.hasNextInt())
            return;
        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] board = new char[m][n];
        System.out.println("Enter grid characters:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }

        System.out.println("Enter word to search:");
        String word = sc.next();

        WordSearch obj = new WordSearch();
        System.out.println("Word exists: " + obj.exist(board, word));

        sc.close();
    }
}
