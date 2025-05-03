package logicBuilding;

/**
 * This class provides two methods to find the first and last occurrence of a target element
 * in a sorted array.
 *
 * Problem Statement:
 * Given a sorted array of integers and a target value, return the starting and ending position
 * of the target value in the array. If the target is not found, return [-1, -1].
 *
 * Approaches:
 * 1. Brute Force Approach - Traverse the array to track first and last occurrences.
 * 2. Optimal Approach - Use binary search (lower bound and upper bound logic).
 *
 * Time Complexity:
 * - Brute Force: O(n)
 * - Optimal (Using Bounds): O(log n)
 *
 * Space Complexity: O(1)
 *
 * Example:
 * Input: nums = [5, 7, 7, 8, 8, 10], target = 8
 * Output: [3, 4] (first occurrence at index 3, last at index 4)
 */
public class FirstLastXOccurence_3 {

    /**
     * Brute force approach to find first and last index of the target.
     *
     * @param nums   The sorted input array
     * @param target The value to search for
     * @return An array with the first and last occurrence index
     */
    public int[] searchRangeBrute(int[] nums, int target) {
        int length = nums.length;
        int firstIndex = -1;
        int lastIndex = -1;

        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                if (firstIndex == -1) {
                    firstIndex = i;
                }
                lastIndex = i;
            }
        }

        return new int[] { firstIndex, lastIndex };
    }

    /**
     * Finds the lower bound (first index) of the target using binary search.
     *
     * @param nums   The sorted input array
     * @param target The value to search for
     * @return The index of the first element >= target
     */
    private int lowerBound(int[] nums, int target) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        int answer = length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    /**
     * Finds the upper bound (one past the last index) of the target using binary search.
     *
     * @param nums   The sorted input array
     * @param target The value to search for
     * @return The index of the first element > target
     */
    private int upperBound(int[] nums, int target) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        int answer = length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > target) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    /**
     * Optimal approach using binary search to find the first and last occurrence of the target.
     *
     * @param nums   The sorted input array
     * @param target The value to search for
     * @return An array with the first and last occurrence index
     */
    public int[] searchRangeUsingBounds(int[] nums, int target) {
        int firstOccurrence = lowerBound(nums, target);
        if (firstOccurrence == nums.length || nums[firstOccurrence] != target)
            return new int[] { -1, -1 };
        int lastOccurrence = upperBound(nums, target) - 1;
        return new int[] { firstOccurrence, lastOccurrence };
    }

    public static void main(String[] args) {
        FirstLastXOccurence_3 searcher = new FirstLastXOccurence_3();

        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        int[] bruteResult = searcher.searchRangeBrute(nums, target);
        System.out.println("Brute Force Result: First = " + bruteResult[0] + ", Last = " + bruteResult[1]);

        int[] optimalResult = searcher.searchRangeUsingBounds(nums, target);
        System.out.println("Optimal Result: First = " + optimalResult[0] + ", Last = " + optimalResult[1]);
    }
}
