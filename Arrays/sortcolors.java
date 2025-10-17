package Arrays;

public class sortcolors {
    class Solution {
        public void sortColors(int[] arr) {
            int n = arr.length;
            int high = n - 1;
            int low = 0, mid = 0;
            while (mid <= high) {
                if (arr[mid] == 0) {

                    int temp = arr[mid];
                    arr[mid] = arr[low];
                    arr[low] = temp;
                    low++;
                    mid++;
                } else if (arr[mid] == 1)
                    mid++;

                else {

                    int temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                }

            }

        }

    }
}
