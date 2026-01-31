package greedy_backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
Problem Statement:
Given an m x n board of characters and a list of strings words, return all words on the board.
Each word must be constructed from letters of sequentially adjacent cells, where 
adjacent cells are horizontally or vertically neighboring. The same letter cell 
may not be used more than once in a word.

Input Format:
- m, n (dimensions)
- m*n grid of characters
- k (number of words)
- k words

Output Format:
- List of found words

Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 12
1 <= words.length <= 3 * 10^4
1 <= words[i].length <= 10

Sample Input:
4 4
o a a n
e t a e
i h k r
i f l v
4
oath pea eat rain
Sample Output:
["eat","oath"]
*/

public class WordSearchII {
    /**
     * Backtracking Approach with Trie:
     * searching each word independently (as in Word Search I) would be inefficient.
     * We insert all target words into a Trie. Then we trigger a DFS from each cell
     * on the board, exploring the board and the Trie simultaneously.
     * 
     * Choice: Move to adjacent cell if it's a valid next character in the Trie.
     * Recursive Call: DFS on neighbors and next Trie node.
     * Backtrack: Unmark cell as visited.
     * 
     * Time Complexity: O(M * N * 3^L) where L is max word length.
     * Space Complexity: O(Total characters in words) for Trie.
     */
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null; // Stores the full word if this node is an end-of-word
    }

    public List<String> findWords(char[][] board, String[] words) {
        // Build Trie
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode curr = root;
            for (char c : w.toCharArray()) {
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
            }
            curr.word = w;
        }

        List<String> result = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (root.children.containsKey(board[r][c])) {
                    dfs(board, r, c, root, result);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode parent, List<String> result) {
        char ch = board[r][c];
        TrieNode curr = parent.children.get(ch);

        // Word found!
        if (curr.word != null) {
            result.add(curr.word);
            curr.word = null; // Avoid adding the same word twice
        }

        // Choice: Mark as visited
        board[r][c] = '#';

        int[] dr = { 0, 0, 1, -1 };
        int[] dc = { 1, -1, 0, 0 };

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                if (curr.children.containsKey(board[nr][nc])) {
                    dfs(board, nr, nc, curr, result);
                }
            }
        }

        // Backtrack
        board[r][c] = ch;

        // Optimization: Remove leaf nodes from Trie to prune search branches
        if (curr.children.isEmpty()) {
            parent.children.remove(ch);
        }
    }

    // Self-fix during implementation: fix the loop to be more robust
    private void dfsFixed(char[][] board, int r, int c, TrieNode parent, List<String> result) {
        char ch = board[r][c];
        TrieNode currNode = parent.children.get(ch);

        if (currNode.word != null) {
            result.add(currNode.word);
            currNode.word = null;
        }

        board[r][c] = '#';
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] != '#') {
                if (currNode.children.containsKey(board[nr][nc])) {
                    dfsFixed(board, nr, nc, currNode, result);
                }
            }
        }
        board[r][c] = ch;
        if (currNode.children.isEmpty())
            parent.children.remove(ch);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimensions m and n:");
        if (!sc.hasNextInt())
            return;
        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] board = new char[m][n];
        System.out.println("Enter board contents:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }

        System.out.println("Enter number of words:");
        int k = sc.nextInt();
        String[] words = new String[k];
        System.out.println("Enter words:");
        for (int i = 0; i < k; i++)
            words[i] = sc.next();

        WordSearchII obj = new WordSearchII();
        List<String> res = obj.findWords(board, words);

        System.out.println("Found words: " + res);
        sc.close();
    }
}
