import java.util.Scanner;

/**
 * Problem 4: Reverse a String
 * 
 * Input Format:
 * A string s.
 * 
 * Output Format:
 * Reversed string.
 * 
 * Approach:
 * Recursive approach by swapping characters at the start and end indices.
 */
public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        char[] charArray = s.toCharArray();
        reverse(charArray, 0, charArray.length - 1);

        System.out.println("Reversed string: " + new String(charArray));
        sc.close();
    }

    /**
     * Recursive function to reverse character array in place.
     */
    public static void reverse(char[] s, int left, int right) {
        // Base case: if left index meets or exceeds right index
        if (left >= right) {
            return;
        }

        // Swap characters
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        // Recursive call for internal part
        reverse(s, left + 1, right - 1);
    }
}
