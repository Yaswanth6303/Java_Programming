package hardfaqs;

/**
 * This class provides two methods to count the number of inversions in an array.
 * An inversion is a pair (i, j) such that i < j and nums[i] > nums[j].
 */
public class CountInversions_4 {

    /**
     * Brute force approach to count the number of inversions in the array.
     * Time Complexity: O(n^2)
     *
     * @param nums The input array
     * @return The total number of inversions in the array
     */
    public long countInversionsBrute(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Helper method for merging two sorted subarrays and counting inversions.
     *
     * @param nums The input array
     * @param low The starting index of the subarray
     * @param mid The middle index where the subarray is divided
     * @param high The ending index of the subarray
     * @return The number of inversions found during the merge step
     */
    private long merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int index = 0;

        long count = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
                // All remaining elements in left subarray are greater than nums[right]
                count += (mid - left + 1);
            }
        }

        while (left <= mid) {
            temp[index++] = nums[left++];
        }

        while (right <= high) {
            temp[index++] = nums[right++];
        }

        System.arraycopy(temp, 0, nums, low, high - low + 1);

        return count;
    }

    /**
     * Recursive helper method for merge sort which also counts inversions.
     *
     * @param nums The input array
     * @param low The starting index
     * @param high The ending index
     * @return The number of inversions found in the subarray
     */
    private long mergeSort(int[] nums, int low, int high) {
        long count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;

            count += mergeSort(nums, low, mid);
            count += mergeSort(nums, mid + 1, high);
            count += merge(nums, low, mid, high);
        }
        return count;
    }

    /**
     * Optimal approach to count inversions using modified merge sort.
     * Time Complexity: O(n log n)
     *
     * @param nums The input array
     * @return The total number of inversions in the array
     */
    public long countInversionsOptimal(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        CountInversions_4 countInversions_4 = new CountInversions_4();

        int[] nums = { 9, 5, 4, 2 };
        System.out.println("Brute Force Inversion Count: " + countInversions_4.countInversionsBrute(nums));

        // Important: Make a fresh copy of the array because mergeSort modifies it
        int[] numsCopy = { 9, 5, 4, 2 };
        System.out.println("Optimal Inversion Count: " + countInversions_4.countInversionsOptimal(numsCopy));
    }
}
