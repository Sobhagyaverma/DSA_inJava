package Recursion;

public class power {
    public static void main(String[] args) {
        int base = 2;
        int exp = 5;
        int ans = power(base, exp);
        System.out.println(base + "^" + exp + " = " + ans);
    }

    public static int power(int base, int exp) {
        if (exp == 0)
            return 1;
        return base * power(base, exp - 1);
    }
}
