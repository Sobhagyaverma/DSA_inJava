package tree;

import java.util.*;

/**
 * Problem 25: Word Search II (LeetCode 212)
 *
 * Input Format:
 * Board dimensions m x n, then board characters,
 * followed by number of words and the words.
 *
 * Output Format:
 * List of all words found in the board.
 *
 * Approach: Build Trie from words, then DFS on board with Trie traversal.
 * This is more efficient than running Word Search I for each word.
 *
 * Time Complexity: O(m * n * 4^L) where L is max word length
 * Space Complexity: O(total characters in all words) for Trie
 *
 * Edge Cases:
 * - Empty board
 * - No words found
 * - Duplicate words in result (use Set)
 * - Words that are prefixes of other words
 */

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word = null; // Store complete word at end node
}

public class WordSearchII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter board dimensions (m n): ");
        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] board = new char[m][n];
        System.out.println("Enter board characters (row by row):");
        for (int i = 0; i < m; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        System.out.print("Enter number of words: ");
        int wordCount = sc.nextInt();
        String[] words = new String[wordCount];
        System.out.println("Enter words:");
        for (int i = 0; i < wordCount; i++) {
            words[i] = sc.next();
        }

        List<String> result = findWords(board, words);
        System.out.println("Words found: " + result);

        sc.close();
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        // Build Trie
        TrieNode root = buildTrie(words);

        // DFS on each cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
        return root;
    }

    private static void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }

        node = node.children[c - 'a'];

        // Found a word
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicates
        }

        // Mark visited
        board[i][j] = '#';

        // Explore all 4 directions
        dfs(board, i + 1, j, node, result);
        dfs(board, i - 1, j, node, result);
        dfs(board, i, j + 1, node, result);
        dfs(board, i, j - 1, node, result);

        // Restore
        board[i][j] = c;
    }
}
