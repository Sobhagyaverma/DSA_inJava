import java.util.*;

/**
 * Problem 16: Top K Frequent Elements
 * 
 * Input Format:
 * n, then n integers, then k.
 * 
 * Output Format:
 * The k most frequent elements.
 * 
 * Approach: Frequency Map + Bucket Sort
 * Time Complexity: O(n) - Single pass for map, single pass for bucket creation
 * and output.
 * Space Complexity: O(n).
 * Why Optimal: Faster than O(n log k) heap approach by using indexed buckets
 * for counts.
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int[] result = topKFrequent(nums, k);
        System.out.println("Top " + k + " frequent: " + Arrays.toString(result));
        sc.close();
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (buckets[freq] == null)
                buckets[freq] = new ArrayList<>();
            buckets[freq].add(key);
        }

        int[] res = new int[k];
        int count = 0;
        for (int i = buckets.length - 1; i >= 0 && count < k; i--) {
            if (buckets[i] != null) {
                for (int val : buckets[i]) {
                    res[count++] = val;
                    if (count == k)
                        break;
                }
            }
        }
        return res;
    }
}
