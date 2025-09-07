package Arrays;

import java.util.*;

public class pallindrome {
    public static void main(String[] args) {
        int n = 121;
        int tem = n;
        int ans = 0;

        while (n > 0) {
            int temp = n % 10;
            ans = (ans * 10) + temp;
            n = n / 10;
        }

        System.out.println(ans);

        if (tem == ans) {
            System.out.println("true");
        } else {
            System.out.println("False");
        }
    }
}
