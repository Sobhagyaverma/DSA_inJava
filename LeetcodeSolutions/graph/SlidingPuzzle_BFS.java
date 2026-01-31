package graph;

import java.util.*;

/*
Problem Statement:
On a 2x3 board, there are five tiles labeled from 1 to 5, and an empty 
square represented by 0. A move consists of choosing 0 and a 4-directionally 
adjacent number and swapping them.
The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
Given the puzzle board, return the least number of moves required so that 
the state of the board is solved. If it is impossible, return -1.

Input Format:
- 2x3 grid of integers

Output Format:
- Minimum moves.

Constraints:
- board.length == 2
- board[i].length == 3
- board[i][j] is an integer in the range [0, 5].
*/

public class SlidingPuzzle_BFS {
    /**
     * Approach: BFS (Shortest Path in State Space)
     * - The state can be represented as a string (e.g., "123450").
     * - Starting from the initial string, use BFS to explore all reachable states
     * by swapping '0' with its adjacent tiles.
     * - Map the 1D indices for string manipulation back to 2D adjacencies.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(V!) where V is the number of tiles (6! = 720).
     * - Space Complexity: O(V!) to store visited states.
     */
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++)
                sb.append(board[i][j]);
        }
        String start = sb.toString();

        // index 0 can swap with indices 1, 3
        // index 1: 0, 2, 4
        // index 2: 1, 5
        // index 3: 0, 4
        // index 4: 1, 3, 5
        // index 5: 2, 4
        int[][] neighbors = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(target))
                    return moves;

                int zeroIdx = curr.indexOf('0');
                for (int nextIdx : neighbors[zeroIdx]) {
                    String nextState = swap(curr, zeroIdx, nextIdx);
                    if (!visited.contains(nextState)) {
                        visited.add(nextState);
                        queue.offer(nextState);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[2][3];
        System.out.println("Enter 2x3 sliding puzzle board (use 0 for empty):");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++)
                board[i][j] = sc.nextInt();
        }

        SlidingPuzzle_BFS solver = new SlidingPuzzle_BFS();
        System.out.println("Minimum moves: " + solver.slidingPuzzle(board));
        sc.close();
    }
}
