package Recursion;

public class FindMinInArray {
    public static void main(String[] args) {
        int arr[] = { 8, 7, 9, 4, 3 };
        int ans = max(arr, 0, 0, arr.length);
        System.out.println(ans);
    }

    public static int max(int[] arr, int l, int Max, int n) {
        if (l >= n)
            return Max;

        Max = Math.max(arr[l], Max);
        l++;
        return max(arr, l, Max, n);
    }

}
