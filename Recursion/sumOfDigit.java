package Recursion;

public class sumOfDigit {
    public static void main(String[] args) {
        int digit = 123;
        int ans = sod(digit, 0);
        System.out.println(ans);
    }

    public static int sod(int n, int sum) {
        if (n <= 0)
            return sum;

        int temp = n % 10;
        sum += temp;
        n = n / 10;
        return sod(n, sum);
    }

}
