package graph;

import java.util.*;

/*
Problem Statement:
A gene string can be represented by an 8-character long string, with 
choices from 'A', 'C', 'G', and 'T'.
Suppose we need to investigate a mutation from a gene string startGene 
to a gene string endGene where one mutation is defined as one character 
change in the gene string.
For example, "AACCGGTT" -> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. 
A gene must be in the bank to make it a valid gene string.
Given the two gene strings startGene and endGene and the gene bank bank, 
return the minimum number of mutations needed to mutate from startGene 
to endGene. If there is no such a mutation, return -1.

Input Format:
- startGene, endGene
- bankCount, followed by bank strings.

Output Format:
- Minimum mutations count.

Constraints:
- startGene.length == 8
- endGene.length == 8
- 0 <= bank.length <= 10
*/

public class MinGeneticMutation_BFS {
    /**
     * Approach: BFS (Shortest Path)
     * - This is almost identical to Word Ladder.
     * - Each valid gene is a node. An edge exists if they differ by 1 character.
     * - BFS explores layer by layer to find the minimum mutation count.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(B * L * 4) where B is bank size and L is gene length
     * (8).
     * - Space Complexity: O(B) for visited set and queue.
     */
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene))
            return -1;

        char[] choices = { 'A', 'C', 'G', 'T' };
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endGene))
                    return mutations;

                char[] currArr = curr.toCharArray();
                for (int j = 0; j < currArr.length; j++) {
                    char original = currArr[j];
                    for (char c : choices) {
                        if (c == original)
                            continue;
                        currArr[j] = c;
                        String next = new String(currArr);
                        if (bankSet.contains(next)) {
                            queue.offer(next);
                            bankSet.remove(next); // Mark visited
                        }
                    }
                    currArr[j] = original;
                }
            }
            mutations++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter startGene and endGene:");
        String start = sc.next();
        String end = sc.next();
        System.out.println("Enter bank size:");
        int n = sc.nextInt();
        String[] bank = new String[n];
        System.out.println("Enter bank genes:");
        for (int i = 0; i < n; i++)
            bank[i] = sc.next();

        MinGeneticMutation_BFS solver = new MinGeneticMutation_BFS();
        System.out.println("Result: " + solver.minMutation(start, end, bank));
        sc.close();
    }
}
