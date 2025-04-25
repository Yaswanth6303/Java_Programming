package hardfaqs;

/**
 * This class provides three approaches to solve the Maximum Product Subarray problem.
 * 
 * Problem Statement:
 * Given an array of integers, find the contiguous subarray within the array
 * which has the largest product.
 * 
 * Approaches:
 * 1. Brute Force Approach - Check all possible subarrays and compute their products
 * 2. Better Approach - Compute product from each starting index to the end
 * 3. Optimal Approach - Track prefix and suffix product in a single pass
 * 
 * Time Complexities:
 * - Brute: O(n^3)
 * - Better: O(n^2)
 * - Optimal: O(n)
 * 
 * Space Complexities:
 * - All approaches use O(1) extra space
 * 
 * Example:
 * Input: [2, 3, -2, 4]
 * Output: 6
 */
public class MaximumProductSubarray_6 {

    /**
     * Brute force approach to find the maximum product subarray.
     * Tries all possible subarrays and computes their products.
     * 
     * @param nums The input array
     * @return Maximum product of any contiguous subarray
     */
    public int maxProductBrute(int[] nums) {
        int n = nums.length;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int product = 1;
                for (int k = i; k <= j; k++) {
                    product *= nums[k];
                }
                result = Math.max(result, product);
            }
        }

        return result;
    }

    /**
     * Better approach that computes the product of subarrays
     * starting from each index.
     * 
     * @param nums The input array
     * @return Maximum product of any contiguous subarray
     */
    public int maxProductBetter(int[] nums) {
        int n = nums.length;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
                result = Math.max(result, product);
            }
        }

        return result;
    }

    /**
     * Optimal approach using prefix and suffix product tracking.
     * Handles the case of negative numbers and zeros.
     * 
     * @param nums The input array
     * @return Maximum product of any contiguous subarray
     */
    public int maxProductOptimal(int[] nums) {
        int n = nums.length;
        int result = Integer.MIN_VALUE;

        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < n; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= nums[i];
            suffix *= nums[n - 1 - i];

            result = Math.max(result, Math.max(prefix, suffix));
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumProductSubarray_6 maximumProductSubarray_6 = new MaximumProductSubarray_6();
        int[] nums = { 4, 5, 3, 7, 1, 2 };

        System.out.println("Brute Force Output: " + maximumProductSubarray_6.maxProductBrute(nums));
        System.out.println("Better Approach Output: " + maximumProductSubarray_6.maxProductBetter(nums));
        System.out.println("Optimal Approach Output: " + maximumProductSubarray_6.maxProductOptimal(nums));
    }
}
