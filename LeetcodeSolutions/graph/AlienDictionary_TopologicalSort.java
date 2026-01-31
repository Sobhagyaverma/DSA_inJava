package graph;

import java.util.*;

/*
Problem Statement:
There is a new alien language that uses the Latin alphabet. However, the order 
among the letters is unknown to you.
You are given a list of strings words from the alien language's dictionary, 
where the strings in words are sorted lexicographically by the rules of this 
new language.
Derive the order of letters in this language. If the order is invalid, return "". 
If multiple orders are possible, return any.

Input Format:
- n (number of words)
- n words

Output Format:
- String representation of the alphabet order.

Constraints:
- 1 <= words.length <= 100
- 1 <= words[i].length <= 100
- words[i] consists of only lowercase English letters.
*/

public class AlienDictionary_TopologicalSort {
    /**
     * Approach: Topological Sort (Kahn's)
     * - Each letter is a node.
     * - Compare adjacent words to find the relative order of two letters.
     * Add a directed edge if word1[i] != word2[i] at the first discrepancy.
     * - Handle edge case where a prefix comes after its child (invalid).
     * - Perform Topological Sort.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(C) where C is the total number of characters in words.
     * - Space Complexity: O(1) as there are at most 26 nodes.
     */
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Initialize all seen characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.put(c, 0);
            }
        }

        // Build Graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            // Edge case: word1 is longer prefix of word2 (invalid)
            if (w1.length() > w2.length() && w1.startsWith(w2))
                return "";

            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    adj.putIfAbsent(c1, new HashSet<>());
                    if (adj.get(c1).add(c2)) {
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        // BFS/Kahn's
        Queue<Character> queue = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0)
                queue.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);
            if (adj.containsKey(curr)) {
                for (char neighbor : adj.get(curr)) {
                    indegree.put(neighbor, indegree.get(neighbor) - 1);
                    if (indegree.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return (sb.length() < indegree.size()) ? "" : sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of words:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();
        String[] words = new String[n];
        System.out.println("Enter words:");
        for (int i = 0; i < n; i++)
            words[i] = sc.next();

        AlienDictionary_TopologicalSort solver = new AlienDictionary_TopologicalSort();
        String result = solver.alienOrder(words);
        System.out.println("Result: " + (result.isEmpty() ? "Invalid order" : result));
        sc.close();
    }
}
