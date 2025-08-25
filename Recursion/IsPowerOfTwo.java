package Recursion;

import java.util.*;

public class IsPowerOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        isPowerOfTwo(n);

        boolean Result = isPowerOfTwo(n);
        System.out.println(Result);

    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1)
            return true;
        if (n <= 0 || n % 2 != 0)
            return false;
        return isPowerOfTwo(n / 2);

    }

}
