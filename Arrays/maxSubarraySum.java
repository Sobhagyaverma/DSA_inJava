package Arrays;

import java.util.*;

public class maxSubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of Array :-");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the N elements of array :- ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the Size of Window :-");
        int k = sc.nextInt();

        int sum = maxsum(arr, k, n);

        System.out.println("Max sum is " + sum);
    }

    public static int maxsum(int[] arr, int k, int n) {

        int maxSum = 0;
        int windowSum = 0;
        int l = 0;
        int r = k - 1;
        for (int i = 0; i <= r; i++) {
            windowSum = windowSum + arr[i];
        }
        r++;

        maxSum = windowSum;
        while (r < n) {
            windowSum = windowSum + arr[r] - arr[l];
            maxSum = Math.max(maxSum, windowSum);
            r++;
            l++;

        }
        return maxSum;
    }

}
