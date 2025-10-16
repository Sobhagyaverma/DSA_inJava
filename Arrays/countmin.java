package Arrays;

import java.util.Arrays;

public class countmin {
    public int maxFrequencyElements(int[] arr) {
        int max = 0;
        for (int num : arr) {
            if (num > max)
                max = num;
        }

        int[] freq = new int[max + 1];

        for (int num : arr) {
            freq[num]++;
        }
        Arrays.sort(freq);
        int sum = freq[freq.length - 1];
        for (int i = freq.length - 2; i >= 0; i--) {
            if (freq[i] == freq[i + 1]) {
                sum += freq[i];
            } else
                break;
        }
        return sum;
    }
}
