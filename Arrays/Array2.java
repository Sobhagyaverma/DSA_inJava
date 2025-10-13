package Arrays;

public class Array2 {

    public static int countFlips(String str, int k) {
        // Convert string to char array since strings in Java are immutable
        char[] arr = str.toCharArray();
        int flips = 0;
        int n = arr.length - k; // max index where a flip can start

        for (int i = 0; i <= n; i++) {
            if (arr[i] == '0') {
                // Flip next k bits
                for (int j = 0; j < k; j++) {
                    arr[i + j] = (arr[i + j] == '0') ? '1' : '0';
                }
                flips++;
            }
        }

        // Check if string is all '1's now
        for (int i = n + 1; i < arr.length; i++) {
            if (arr[i] == '0') {
                return -1; // not possible
            }
        }

        return flips;
    }

    public static void main(String[] args) {
        String str = "000011000";
        int k = 3;
        int result = countFlips(str, k);
        System.out.println("Minimum flips required = " + result);
    }
}
