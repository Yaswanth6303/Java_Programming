package fundamentals;

import java.util.Arrays;

/**
 * A Java program to find the second largest element in an array.
 *
 * This class demonstrates three approaches:
 * 1. Brute-force: Sorts the array and traverses from the end.
 * 2. Better: Uses two passes — one to find the largest, another for second largest.
 * 3. Optimal: Single-pass solution that tracks both the largest and second largest values.
 *
 * Time Complexity:
 * - Brute-force: O(n log n) (due to sorting).
 * - Better: O(2n) ~ O(n) (two linear passes).
 * - Optimal: O(n) (single pass).
 *
 * Space Complexity:
 * - All approaches: O(1) (constant space).
 */
public class SecondLargestElement_3 {

    /**
     * Finds the second largest element using the brute-force approach.
     * 
     * The array is sorted in ascending order and traversed from the end
     * to identify the first unique element that is less than the largest.
     *
     * Time Complexity:
     * - Best Case: O(n log n)
     * - Average Case: O(n log n)
     * - Worst Case: O(n log n)
     *
     * Space Complexity: O(1)
     *
     * @param nums The array of integers.
     * @return The second largest element, or -1 if it does not exist.
     */
    public int secondLargestElementBrute(int[] nums) {
        int n = nums.length;

        if (n < 2) {
            return -1;
        }

        Arrays.sort(nums);
        int largestElement = nums[n - 1];
        int secondLargestElement = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] != largestElement) {
                secondLargestElement = nums[i];
                break;
            }
        }

        return secondLargestElement;
    }

    /**
     * Finds the second largest element using a two-pass better approach.
     * 
     * First, the largest element is identified.
     * Then the array is traversed again to find the second largest distinct element.
     *
     * Time Complexity:
     * - Best Case: O(n)
     * - Average Case: O(n)
     * - Worst Case: O(n)
     *
     * Space Complexity: O(1)
     *
     * @param nums The array of integers.
     * @return The second largest element, or -1 if it does not exist.
     */
    public int secondLargestElementBetter(int[] nums) {
        int n = nums.length;

        if (n < 2) {
            return -1;
        }

        int largestElement = Integer.MIN_VALUE;
        int secondLargestElement = Integer.MIN_VALUE;

        // First pass: find the largest
        for (int i = 0; i < n; i++) {
            largestElement = Math.max(largestElement, nums[i]);
        }

        // Second pass: find second largest
        for (int i = 0; i < n; i++) {
            if (nums[i] != largestElement && nums[i] > secondLargestElement) {
                secondLargestElement = nums[i];
            }
        }

        return secondLargestElement == Integer.MIN_VALUE ? -1 : secondLargestElement;
    }

    /**
     * Finds the second largest element using an optimal single-pass approach.
     * 
     * While traversing, both the largest and second largest elements are
     * tracked and updated in real-time.
     *
     * Time Complexity:
     * - Best Case: O(n)
     * - Average Case: O(n)
     * - Worst Case: O(n)
     *
     * Space Complexity: O(1)
     *
     * @param nums The array of integers.
     * @return The second largest element, or -1 if it does not exist.
     */
    public int secondLargestElementOptimal(int[] nums) {
        int n = nums.length;

        if (n < 2) {
            return -1;
        }

        int largestElement = Integer.MIN_VALUE;
        int secondLargestElement = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] > largestElement) {
                secondLargestElement = largestElement;
                largestElement = nums[i];
            } else if (nums[i] > secondLargestElement && nums[i] != largestElement) {
                secondLargestElement = nums[i];
            }
        }

        return secondLargestElement == Integer.MIN_VALUE ? -1 : secondLargestElement;
    }

    public static void main(String[] args) {
        SecondLargestElement_3 secondLargestElement_3 = new SecondLargestElement_3();
        int[] nums = {100, 42, 33, 54, 10};

        System.out.println("Second largest element in the array is (secondLargestElementBrute): " + 
                            secondLargestElement_3.secondLargestElementBrute(nums));
        System.out.println("Second largest element in the array is (secondLargestElementBetter): " + 
                            secondLargestElement_3.secondLargestElementBetter(nums));
        System.out.println("Second largest element in the array is (secondLargestElementOptimal): " + 
                            secondLargestElement_3.secondLargestElementOptimal(nums));
    }
}
