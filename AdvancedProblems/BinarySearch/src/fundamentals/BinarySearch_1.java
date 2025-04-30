package fundamentals;

/**
 * This class provides two approaches to perform Binary Search on a sorted array.
 *
 * Problem Statement:
 * Given a sorted array of integers and a target value, return the index of the target
 * if it exists in the array. Otherwise, return -1.
 *
 * Approaches:
 * 1. Iterative Approach - Uses a while loop to perform binary search.
 * 2. Recursive Approach - Uses recursion to divide and search in the array.
 *
 * Time Complexity: O(log n)
 * Space Complexity:
 * - Iterative Approach: O(1)
 * - Recursive Approach: O(log n) due to recursion stack
 *
 * Example:
 * Input: nums = [-1, 0, 3, 5, 9, 12], target = 9
 * Output: 4 (since nums[4] == 9)
 */
public class BinarySearch_1 {

    /**
     * Iterative approach to perform binary search.
     *
     * @param nums   The sorted input array
     * @param target The value to search for
     * @return The index of the target if found; otherwise, -1
     */
    public int binarySearchIterativeApproach(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * Recursive binary search helper function.
     *
     * @param nums   The sorted input array
     * @param low    The starting index of the current search segment
     * @param high   The ending index of the current search segment
     * @param target The value to search for
     * @return The index of the target if found; otherwise, -1
     */
    public int binarySearchRecursive(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearchRecursive(nums, low, mid - 1, target);
        } else {
            return binarySearchRecursive(nums, mid + 1, high, target);
        }
    }

    /**
     * Wrapper method for the recursive approach to initiate the search.
     *
     * @param nums   The sorted input array
     * @param target The value to search for
     * @return The index of the target if found; otherwise, -1
     */
    public int binarySearchRecursiveApproach(int[] nums, int target) {
        int n = nums.length;
        return binarySearchRecursive(nums, 0, n - 1, target);
    }

    public static void main(String[] args) {
        BinarySearch_1 binarySearch_1 = new BinarySearch_1();
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 9;

        System.out.println("Iterative Approach Result: " + binarySearch_1.binarySearchIterativeApproach(nums, target));
        System.out.println("Recursive Approach Result: " + binarySearch_1.binarySearchRecursiveApproach(nums, target));
    }
}
