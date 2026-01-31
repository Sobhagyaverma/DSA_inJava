package graph;

import java.util.Scanner;

/*
Problem Statement:
Given an m x n 2D grid of characters board and a string word, return true if word 
exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where 
adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Input Format:
- m, n
- m*n grid of characters
- word string

Output Format:
- Boolean.

Constraints:
- m, n <= 6
- word.length <= 15
*/

public class WordSearch_DFS {
    /**
     * Approach: DFS with Backtracking
     * - Iterate through the board. Start DFS from cells matching the first char
     * of the word.
     * - For each cell, track visited nodes to avoid reuse.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(M * N * 3^L) where L is word length.
     * - Space Complexity: O(L) for recursion stack.
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int k) {
        if (k == word.length())
            return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(k)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#'; // Mark visited

        boolean found = dfs(board, word, r + 1, c, k + 1) ||
                dfs(board, word, r - 1, c, k + 1) ||
                dfs(board, word, r, c + 1, k + 1) ||
                dfs(board, word, r, c - 1, k + 1);

        board[r][c] = temp; // Backtrack
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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println("Enter word:");
        String word = sc.next();

        WordSearch_DFS solver = new WordSearch_DFS();
        System.out.println("Exists: " + solver.exist(board, word));
        sc.close();
    }
}
