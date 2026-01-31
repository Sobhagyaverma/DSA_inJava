package greedy_backtracking;

import java.util.Scanner;

/*
Problem Statement:
Write a program to solve a Sudoku puzzle by filling the empty cells.
A sudoku solution must satisfy all of the following rules:
1. Each of the digits 1-9 must occur exactly once in each row.
2. Each of the digits 1-9 must occur exactly once in each column.
3. Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Input Format:
- 9x9 grid where each row represents a row of Sudoku.

Output Format:
- 9x9 solved grid.

Constraints:
board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.

Sample Input (Part of it):
5 3 . . 7 . . . .
6 . . 1 9 5 . . .
. 9 8 . . . . 6 .
(etc.)
*/

public class SudokuSolver {
    /**
     * Backtracking Approach:
     * We iterate through the board to find an empty cell ('.').
     * We try placing every digit from '1' to '9' in that cell.
     * If placing a digit is valid according to Sudoku rules, we move to the next
     * empty cell.
     * 
     * Choice: Place digit 'D' in cell [r, c].
     * Recursive Call: Call to solve the board with 'D' placed.
     * Backtrack: Replace 'D' with '.' if the recursive call results in an invalid
     * board.
     * 
     * Time Complexity: O(9^(N*N)) theoretically, but much faster due to pruning.
     * Space Complexity: O(N*N) to store the board and recursion stack.
     */
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    for (char d = '1'; d <= '9'; d++) {
                        if (isValid(board, r, c, d)) {
                            // Choice
                            board[r][c] = d;

                            // Recursive Call
                            if (solve(board))
                                return true;

                            // Backtrack
                            board[r][c] = '.';
                        }
                    }
                    return false; // No digit works in this cell
                }
            }
        }
        return true; // All cells filled
    }

    private boolean isValid(char[][] board, int row, int col, char d) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == d)
                return false;
            // Check column
            if (board[i][col] == d)
                return false;
            // Check 3x3 sub-grid
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == d)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];
        System.out.println("Enter 9x9 Sudoku board (use '.' for empty cells):");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }

        SudokuSolver obj = new SudokuSolver();
        obj.solveSudoku(board);

        System.out.println("\nSolved Sudoku:");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
