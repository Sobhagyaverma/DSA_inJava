package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        solve(0, board, result, n);
        return result;
    }

    private void solve(int col, char[][] board, List<List<String>> result, int n) {
        if (col == n) {
            result.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, result, n);
                board[row][col] = '.'; // Backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        // Check this row on left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') return false;
        }

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check lower diagonal on left side
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of N: ");
        int n = sc.nextInt();

        NQueens solver = new NQueens();
        List<List<String>> solutions = solver.solveNQueens(n);

        System.out.println("Total solutions: " + solutions.size());
        
        int count = 1;
        for (List<String> solution : solutions) {
            System.out.println("Solution " + count++ + ":");
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
        
        sc.close();
    }
}
