package Patterns;

public class Pyramid {
    public static void main(String[] args) {
        int n = 5;
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= cnt; j++) {
                System.out.print("*");
            }
            cnt = cnt + 2;
            System.out.println();
        }

    }

}
