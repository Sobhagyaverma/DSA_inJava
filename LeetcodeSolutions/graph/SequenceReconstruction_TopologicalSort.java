package graph;

import java.util.*;

/*
Problem Statement:
Check whether there is a unique reconstruction of the sequence org from the 
sequences seqs. 
org is a permutation of the integers from 1 to n, with 1 <= n <= 10^4.
Reconstruction means building a shortest common supersequence of seqs 
(i.e., a shortest sequence so that all sequences in seqs are subsequences of it).
Return true if there's ONLY one unique supersequence.

Input Format:
- n
- number of sequences s
- s lines, each starting with count of elements in sequence.

Output Format:
- Boolean.

Constraints:
- 1 <= n <= 10^4
*/

public class SequenceReconstruction_TopologicalSort {
    /**
     * Approach: Topological Sort (Kahn's)
     * - Build a graph where seq[i] -> seq[i+1].
     * - A unique topological sort exists if and only if at every step of
     * Kahn's algorithm, the queue has exactly ONE element.
     * - Also check if the sorted order matches 'org'.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(V + E) where V is n and E is total length of sequences.
     * - Space Complexity: O(V + E)
     */
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        // Use a set to track actual elements present in seqs
        Set<Integer> nodes = new HashSet<>();
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                nodes.add(seq.get(i));
                indegree.putIfAbsent(seq.get(i), 0);
                if (i > 0) {
                    int u = seq.get(i - 1);
                    int v = seq.get(i);
                    adj.putIfAbsent(u, new HashSet<>());
                    if (adj.get(u).add(v)) {
                        indegree.put(v, indegree.get(v) + 1);
                    }
                }
            }
        }

        // Validity check: nodes in seqs must exactly match org elements
        if (nodes.size() != n)
            return false;

        Queue<Integer> queue = new LinkedList<>();
        for (int i : indegree.keySet()) {
            if (indegree.get(i) == 0)
                queue.offer(i);
        }

        int index = 0;
        while (!queue.isEmpty()) {
            // Uniqueness check: Queue must have exactly 1 element
            if (queue.size() > 1)
                return false;

            int curr = queue.poll();
            if (index >= n || org[index++] != curr)
                return false;

            if (adj.containsKey(curr)) {
                for (int neighbor : adj.get(curr)) {
                    indegree.put(neighbor, indegree.get(neighbor) - 1);
                    if (indegree.get(neighbor) == 0)
                        queue.offer(neighbor);
                }
            }
        }

        return index == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n (size of org):");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();
        int[] org = new int[n];
        System.out.println("Enter org integers:");
        for (int i = 0; i < n; i++)
            org[i] = sc.nextInt();

        System.out.println("Enter number of sequences:");
        int sCount = sc.nextInt();
        List<List<Integer>> seqs = new ArrayList<>();
        System.out.println("Enter sequences (length followed by elements):");
        for (int i = 0; i < sCount; i++) {
            int len = sc.nextInt();
            List<Integer> seq = new ArrayList<>();
            for (int j = 0; j < len; j++)
                seq.add(sc.nextInt());
            seqs.add(seq);
        }

        SequenceReconstruction_TopologicalSort solver = new SequenceReconstruction_TopologicalSort();
        System.out.println("Unique reconstruction possible: " + solver.sequenceReconstruction(org, seqs));
        sc.close();
    }
}
