package Arrays;

import java.util.*;

public class maxScore {
    public static void main(String[] args) {
        System.out.println("Enter the size of Array:-");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter the elements of array:-");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the window size :-");
        int k = sc.nextInt();

        int ans = maxscore(arr, k, n - 1);
        System.out.println("Your answer is " + ans);
    }

    public static int maxscore(int[] arr, int k, int n) {
        int maxSum = 0, sum = 0, l = 1;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        maxSum = sum;

        for (int i = n; i > n - k; i--) {
            sum = sum - arr[k - l] + arr[i];
            maxSum = Math.max(maxSum, sum);
            l++;
        }
        return maxSum;

    }
}
