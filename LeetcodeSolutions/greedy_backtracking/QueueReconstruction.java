package greedy_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Problem Statement:
You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). 
Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people 
in front who have a height greater than or equal to hi.
Reconstruct and return the queue that is represented by the input array people. 
The returned queue should be formatted as an array where each element contains [hi, ki].

Input Format:
- n (number of people)
- n pairs of integers (height, k-value)

Output Format:
- Reconstructed queue pairs

Constraints:
1 <= people.length <= 2000
0 <= hi <= 10^6
0 <= ki < n

Sample Input:
6
7 0
4 4
7 1
5 0
6 1
5 2
Sample Output:
[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]
*/

public class QueueReconstruction {
    /**
     * Greedy Choice:
     * 1. Sort people by height in descending order.
     * 2. For people with the same height, sort them by their k-value in ascending
     * order.
     * 3. Process each person from the sorted list and insert them into the result
     * list
     * at the index equal to their k-value.
     * 
     * Why Optimal:
     * - By sorting heights descending, when we insert a person at index 'k',
     * all people already in the list have height >= current person's height.
     * - Inserting at index 'k' satisfies the condition that there are exactly 'k'
     * people in front who are taller or equal.
     * - Later insertions of shorter people won't break this condition.
     * 
     * Time Complexity: O(n^2) - List insertion in Java is O(n).
     * Space Complexity: O(n) - To store the result list.
     */
    public static int[][] reconstructQueue(int[][] people) {
        // Sort: height DESC, k-value ASC
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] != p2[0]) {
                return p2[0] - p1[0]; // Sort by height descending
            } else {
                return p1[1] - p2[1]; // Sort by k-value ascending
            }
        });

        List<int[]> result = new ArrayList<>();
        for (int[] p : people) {
            // Greedy insertion: k-value is the index
            result.add(p[1], p);
        }

        return result.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of people:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        int[][] people = new int[n][2];
        System.out.println("Enter height and k-value for each person:");
        for (int i = 0; i < n; i++) {
            people[i][0] = sc.nextInt();
            people[i][1] = sc.nextInt();
        }

        int[][] result = reconstructQueue(people);
        System.out.println("Reconstructed Queue:");
        for (int[] p : result) {
            System.out.print("[" + p[0] + ", " + p[1] + "] ");
        }
        System.out.println();

        sc.close();
    }
}
