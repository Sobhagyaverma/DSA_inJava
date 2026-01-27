import java.util.*;

/**
 * Problem 10: Container With Most Water
 * 
 * Input Format:
 * n, then n integers representing heights.
 * 
 * Output Format:
 * Maximum area of water trapped.
 * 
 * Approach: Two Pointers
 * Time Complexity: O(n) - Single pass.
 * Space Complexity: O(1).
 * Why Optimal: Moving the pointer with the smaller height maximizes the chance
 * of finding a larger area.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] height = new int[n];
        System.out.println("Enter heights:");
        for (int i = 0; i < n; i++)
            height[i] = sc.nextInt();

        System.out.println("Max Water: " + maxArea(height));
        sc.close();
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, h * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
