package greedy_backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Problem Statement:
The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration where 'Q' and '.' 
represent a queen and an empty space, respectively.

Input Format:
- An integer n

Output Format:
- List of board configurations

Constraints:
1 <= n <= 9

Sample Input:
4
Sample Output:
Solution 1:
. Q . . 
. . . Q 
Q . . . 
. . Q . 

Solution 2:
. . Q . 
Q . . . 
. . . Q 
. Q . . 
*/

public class NQueens {
    /**
     * Backtracking Approach:
     * We place queens row by row. For each row, we try to place a queen in every
     * column.
     * Before placing, we check if the position is attacked by any queen in the
     * previous rows.
     * 
     * Choice: Place a queen at [row, col].
     * Recursive Call: Move to [row + 1].
     * Backtrack: Remove the queen from [row, col] to try next column.
     * Pruning: Check column, positive diagonal, and negative diagonal constraints.
     * 
     * Time Complexity: O(n!) - We have n choices for first row, n-1 for second,
     * etc.
     * Space Complexity: O(n^2) - For the board and recursion stack.
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        }

        // Trackers for columns and diagonals
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // row + col
        boolean[] diag2 = new boolean[2 * n]; // row - col + n

        backtrack(0, n, board, res, cols, diag1, diag2);
        return res;
    }

    private void backtrack(int row, int n, char[][] board, List<List<String>> res,
            boolean[] cols, boolean[] diag1, boolean[] diag2) {
        // Base case: all rows filled
        if (row == n) {
            res.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            // Pruning: check if placement is valid
            if (cols[col] || diag1[row + col] || diag2[row - col + n])
                continue;

            // Choice: Place Queen
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[row + col] = true;
            diag2[row - col + n] = true;

            // Recursive Call: next row
            backtrack(row + 1, n, board, res, cols, diag1, diag2);

            // Backtrack: Remove Queen
            board[row][col] = '.';
            cols[col] = false;
            diag1[row + col] = false;
            diag2[row - col + n] = false;
        }
    }

    private List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            path.add(new String(board[i]));
        }
        return path;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        NQueens obj = new NQueens();
        List<List<String>> results = obj.solveNQueens(n);

        System.out.println("Total solutions: " + results.size());
        for (int i = 0; i < results.size(); i++) {
            System.out.println("\nSolution " + (i + 1) + ":");
            for (String row : results.get(i)) {
                for (char c : row.toCharArray())
                    System.out.print(c + " ");
                System.out.println();
            }
        }
        sc.close();
    }
}
