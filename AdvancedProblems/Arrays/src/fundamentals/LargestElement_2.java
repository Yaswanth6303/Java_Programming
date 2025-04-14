package fundamentals;

import java.util.Arrays;

/**
 * A Java program to find the largest element in an array.
 *
 * This class demonstrates two approaches to solving the problem:
 * 1. Brute-force approach using sorting.
 * 2. Optimal approach using a single traversal.
 *
 * Time Complexity:
 * - Brute-force: O(n log n) (due to sorting).
 * - Optimal: O(n) (single pass through the array).
 *
 * Space Complexity:
 * - Both approaches: O(1) (in-place operations, except minor overhead for sorting).
 */
public class LargestElement_2 {

    /**
     * Finds the largest element in the given array using the brute-force approach.
     * 
     * The array is first sorted in ascending order, and the last element,
     * which is the largest, is returned.
     * 
     * Time Complexity:
     * - Best Case: O(n log n) — Sorting is always O(n log n) regardless of input.
     * - Average Case: O(n log n)
     * - Worst Case: O(n log n)
     * 
     * Space Complexity: O(1) (in-place sort)
     *
     * @param nums The array of integers.
     * @return The largest element in the array.
     */
    public int largestElementBrute(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }

    /**
     * Finds the largest element in the given array using the optimal approach.
     * 
     * Iterates through the array once and continuously updates the maximum element found.
     * 
     * Time Complexity:
     * - Best Case: O(n) — Must traverse all elements even if the largest is first.
     * - Average Case: O(n)
     * - Worst Case: O(n)
     * 
     * Space Complexity: O(1)
     *
     * @param nums The array of integers.
     * @return The largest element in the array.
     */
    public int largestElementOptimal(int[] nums) {
        int n = nums.length;
        int maximumElement = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] > maximumElement) {
                maximumElement = nums[i];
            }
        }

        return maximumElement;
    }

    public static void main(String[] args) {
        LargestElement_2 largestElement_2 = new LargestElement_2();
        int[] nums = {100, 42, 33, 54, 10};

        System.out.println("Largest element in the array is (largestElementBrute): " + 
                            largestElement_2.largestElementBrute(nums));
        System.out.println("Largest element in the array is (largestElementOptimal): " + 
                            largestElement_2.largestElementOptimal(nums));
    }
}
