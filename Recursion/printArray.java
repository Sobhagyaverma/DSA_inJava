package Recursion;

public class printArray {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int ans = soa(arr, 0, 0, arr.length);
        System.out.println(ans);
    }

    public static int soa(int[] arr, int sum, int l, int n) {
        if (l >= n)
            return sum;

        sum += arr[l];
        l++;

        return soa(arr, sum, l, n);
    }
}
