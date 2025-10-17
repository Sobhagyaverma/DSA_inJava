package Arrays;

public class Contanerwithmostwater {
    public int maxArea(int[] nums) {
        int n = nums.length;
        int max = 0;
        int l = 0, r = n - 1;

        while (l < r) {
            int lon = Math.min(nums[l], nums[r]);
            int width = r - l;
            int ans = lon * width;
            max = Math.max(ans, max);
            if (nums[l] > nums[r])
                r--;
            else
                l++;
        }
        return max;
    }
}
