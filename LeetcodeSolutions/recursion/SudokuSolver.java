import java.util.*;

/**
 * Problem 19: Sudoku Solver
 * 
 * Input Format:
 * 9 lines, each containing 9 characters (1-9 or '.').
 * 
 * Output Format:
 * The completed Sudoku grid.
 * 
 * Approach:
 * Backtracking by filling empty cells and checking validity (O(9^(n*n))).
 */
public class SudokuSolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];
        System.out.println("Enter 9x9 Sudoku board (use '.' for empty):");
        for (int i = 0; i < 9; i++) {
            String line = sc.next();
            for (int j = 0; j < 9; j++)
                board[i][j] = line.charAt(j);
        }

        if (solve(board)) {
            System.out.println("Solved board:");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++)
                    System.out.print(board[i][j] + " ");
                System.out.println();
            }
        } else {
            System.out.println("No solution exists.");
        }
        sc.close();
    }

    private static boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board))
                                return true;
                            else
                                board[i][j] = '.'; // backtrack
                        }
                    }
                    return false; // No digit fits here
                }
            }
        }
        return true; // Solved
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == c)
                return false;
            // Check column
            if (board[i][col] == c)
                return false;
            // Check 3x3 block
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }
}
