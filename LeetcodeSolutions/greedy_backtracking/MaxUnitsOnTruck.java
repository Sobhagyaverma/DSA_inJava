package greedy_backtracking;

import java.util.Arrays;
import java.util.Scanner;

/*
Problem Statement:
You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, 
where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
- numberOfBoxesi is the number of boxes of type i.
- numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. 
You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
Return the maximum total number of units that can be put on the truck.

Input Format:
- n (number of box types)
- n pairs of integers (boxes, units per box)
- truckSize (integer)

Output Format:
- Maximum total units

Constraints:
1 <= boxTypes.length <= 1000
1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
1 <= truckSize <= 10^6

Sample Input:
3
1 3
2 2
3 1
4
Sample Output:
8 (1x3 + 2x2 + 1x1 = 8)
*/

public class MaxUnitsOnTruck {
    /**
     * Greedy Choice:
     * To maximize the total units, we should prioritize putting boxes with the
     * highest
     * number of units per box onto the truck first.
     * 1. Sort boxTypes by units per box in descending order.
     * 2. Fill the truck capacity with these boxes until the truck is full.
     * 
     * Why Optimal:
     * This is a variation of the fractional knapsack problem. Since each box takes
     * up exactly 1 'space' in the truck, picking the most 'valuable' space (most
     * units)
     * results in the global optimum.
     * 
     * Time Complexity: O(n log n) - Sorting.
     * Space Complexity: O(1) or O(log n).
     */
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort by units per box DESC
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0;
        for (int[] box : boxTypes) {
            int numBoxes = box[0];
            int unitsPerBox = box[1];

            // How many of these boxes can we fit?
            int take = Math.min(numBoxes, truckSize);
            totalUnits += take * unitsPerBox;
            truckSize -= take;

            if (truckSize == 0)
                break;
        }

        return totalUnits;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of box types:");
        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt();

        int[][] boxTypes = new int[n][2];
        System.out.println("Enter [number of boxes] and [units per box] for each type:");
        for (int i = 0; i < n; i++) {
            boxTypes[i][0] = sc.nextInt();
            boxTypes[i][1] = sc.nextInt();
        }

        System.out.println("Enter truck size:");
        int truckSize = sc.nextInt();

        System.out.println("Maximum total units: " + maximumUnits(boxTypes, truckSize));
        sc.close();
    }
}
