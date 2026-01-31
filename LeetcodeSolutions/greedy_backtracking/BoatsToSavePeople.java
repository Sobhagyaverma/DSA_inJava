package greedy_backtracking;

import java.util.Arrays;
import java.util.Scanner;

/*
Problem Statement:
You are given an array people where people[i] is the weight of the ith person, 
and an infinite number of boats where each boat can carry a maximum weight of limit. 
Each boat carries at most two people at the same time, provided the sum of the 
weight of those people is at most limit.
Return the minimum number of boats to carry every given person.

Input Format:
- n (number of people)
- n weights (integers)
- limit (integer)

Output Format:
- Minimum number of boats

Constraints:
1 <= people.length <= 5 * 10^4
1 <= people[i] <= limit <= 3 * 10^4

Sample Input:
4
3 2 2 1
3
Sample Output:
3 (1+2, 2, 3)
*/

public class BoatsToSavePeople {
    /**
     * Greedy Choice:
     * To minimize boats, we should try to pair the heaviest person with the
     * lightest person in the same boat.
     * 1. Sort the weights.
     * 2. Use two pointers: 'light' (index 0) and 'heavy' (index n-1).
     * 3. If people[light] + people[heavy] <= limit, they both fit. Move both
     * pointers.
     * 4. Else, the heavy person must take a boat alone. Move only the 'heavy'
     * pointer.
     * 
     * Why Optimal:
     * The heaviest person MUST go. Pairing them with the lightest person available
     * is the most efficient use of capacity because any other person paired
     * with the heaviest might not fit, or if they do, they are wasting potential
     * space that could have been used by someone heavier.
     * 
     * Time Complexity: O(n log n) - Sorting.
     * Space Complexity: O(1) or O(log n).
     */
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int boats = 0;
        int light = 0;
        int heavy = people.length - 1;

        while (light <= heavy) {
            boats++;
            // If the lightest and heaviest can fit together
            if (people[light] + people[heavy] <= limit) {
                light++;
            }
            // Heaviest person always takes a boat
            heavy--;
        }

        return boats;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of people:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        int[] people = new int[n];
        System.out.println("Enter weights:");
        for (int i = 0; i < n; i++) {
            people[i] = sc.nextInt();
        }

        System.out.println("Enter boat limit:");
        int limit = sc.nextInt();

        System.out.println("Minimum number of boats needed: " + numRescueBoats(people, limit));
        sc.close();
    }
}
