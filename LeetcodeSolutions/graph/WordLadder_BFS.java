package graph;

import java.util.*;

/*
Problem Statement:
A transformation sequence from word beginWord to word endWord using a dictionary wordList 
is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
- Every adjacent pair of words differs by exactly one letter.
- Every si is in wordList.
Return the number of words in the shortest transformation sequence, or 0 if none.

Input Format:
- beginWord, endWord
- count of words in list, followed by the words.

Output Format:
- Integer length.

Constraints:
- 1 <= beginWord.length <= 10
- 1 <= wordList.length <= 5000
*/

public class WordLadder_BFS {
    /**
     * Approach: BFS (Shortest Path in Unweighted Graph)
     * - Each word is a node. An edge exists between words differing by 1 char.
     * - Use BFS to find the shortest path from beginWord to endWord.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(M^2 * N) where M is word length and N is wordList size.
     * (For each word in queue, iterate M times, and for each M, replace char [26
     * options],
     * checking existence in set takes O(M)).
     * - Space Complexity: O(M * N)
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord))
                    return level;

                char[] chars = curr.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original)
                            continue;
                        chars[j] = c;
                        String next = new String(chars);
                        if (set.contains(next)) {
                            queue.offer(next);
                            set.remove(next); // Mark visited
                        }
                    }
                    chars[j] = original;
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter beginWord and endWord:");
        String b = sc.next();
        String e = sc.next();
        System.out.println("Enter wordList count:");
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        System.out.println("Enter words:");
        for (int i = 0; i < n; i++)
            list.add(sc.next());

        WordLadder_BFS solver = new WordLadder_BFS();
        System.out.println("Shortest path length: " + solver.ladderLength(b, e, list));
        sc.close();
    }
}
