package tree;

import java.util.Scanner;

/**
 * Problem 24: Implement Trie (LeetCode 208)
 *
 * Input Format:
 * Operations: 1=insert word, 2=search word, 3=startsWith prefix, 0=exit
 *
 * Output Format:
 * Results of search and startsWith operations.
 *
 * Approach: Trie data structure with TrieNode containing children array and
 * isEnd flag.
 *
 * Time Complexity: O(m) for insert, search, startsWith where m is word length.
 * Space Complexity: O(n * m) where n is number of words.
 *
 * Edge Cases:
 * - Empty string
 * - Single character
 * - Overlapping prefixes
 */

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        children = new TrieNode[26]; // a-z
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

public class ImplementTrie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();

        System.out.println("Operations: 1=insert, 2=search, 3=startsWith, 0=exit");

        while (true) {
            System.out.print("Enter operation: ");
            int op = sc.nextInt();
            sc.nextLine(); // consume newline

            if (op == 0)
                break;

            System.out.print("Enter word/prefix: ");
            String word = sc.nextLine();

            switch (op) {
                case 1:
                    trie.insert(word);
                    System.out.println("Inserted: " + word);
                    break;
                case 2:
                    boolean found = trie.search(word);
                    System.out.println("Search '" + word + "': " + found);
                    break;
                case 3:
                    boolean hasPrefix = trie.startsWith(word);
                    System.out.println("StartsWith '" + word + "': " + hasPrefix);
                    break;
                default:
                    System.out.println("Invalid operation");
            }
        }

        sc.close();
    }
}
