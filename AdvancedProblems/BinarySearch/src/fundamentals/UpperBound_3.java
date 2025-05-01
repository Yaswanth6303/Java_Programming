package fundamentals;

/**
 * This class provides two approaches to find the upper bound of a given value in a sorted array.
 *
 * Problem Statement:
 * Given a sorted array of integers and a target value `x`, return the index of the first element
 * that is strictly greater than `x`. If no such element exists, return -1.
 *
 * Approaches:
 * 1. Brute Force Approach - Linear scan through the array to find the first element greater than `x`.
 * 2. Binary Search Approach - Efficiently finds the smallest index with value greater than `x`.
 *
 * Time Complexity:
 * - Brute Force Approach: O(n)
 * - Binary Search Approach: O(log n)
 *
 * Space Complexity: O(1)
 *
 * Example:
 * Input: nums = {1, 2, 4, 6, 8}, x = 4
 * Output: 3 (since nums[3] == 6)
 */
public class UpperBound_3 {

    /**
     * Brute force approach to find the upper bound.
     *
     * @param nums The sorted input array
     * @param x    The value to find the upper bound for
     * @return The index of the first element greater than x; otherwise, -1
     */
    public int upperBoundBruteForce(int[] nums, int x) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > x) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Binary search approach to find the upper bound.
     *
     * @param nums The sorted input array
     * @param x    The value to find the upper bound for
     * @return The index of the first element greater than x; otherwise, -1
     */
    public int upperBoundBinarySearch(int[] nums, int x) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int smallestIndex = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > x) {
                smallestIndex = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return smallestIndex == n ? -1 : smallestIndex;
    }

    public static void main(String[] args) {
        UpperBound_3 upperBound = new UpperBound_3();
        int[] nums = {1, 2, 2, 3};
        int x = 2;

        int bruteResult = upperBound.upperBoundBruteForce(nums, x);
        int binaryResult = upperBound.upperBoundBinarySearch(nums, x);

        System.out.println("Brute Force Upper Bound Index: " + bruteResult);
        System.out.println("Binary Search Upper Bound Index: " + binaryResult); 
    }
}
