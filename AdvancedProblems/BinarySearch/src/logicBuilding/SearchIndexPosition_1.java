package logicBuilding;

/**
 * This class provides two approaches to find the insert position of a target in a sorted array.
 *
 * Problem Statement:
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be inserted in order.
 *
 * Approaches:
 * 1. Brute Force Approach - Iterates through the array linearly to find the correct index.
 * 2. Optimal Approach - Uses Binary Search to find the index efficiently.
 *
 * Time Complexity:
 * - Brute Force Approach: O(n)
 * - Optimal Approach: O(log n)
 *
 * Space Complexity: O(1) for both approaches
 *
 * Example:
 * Input: nums = [1, 3, 5, 6], target = 5
 * Output: 2 (since nums[2] == 5)
 */
public class SearchIndexPosition_1 {

    /**
     * Brute force approach to find the insert position.
     *
     * @param nums   The sorted input array
     * @param target The value to search or insert
     * @return The index at which the target is found or should be inserted
     */
    public int searchInsertPositionBrute(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return n; 
    }

    /**
     * Optimal approach using binary search to find the insert position.
     *
     * @param nums   The sorted input array
     * @param target The value to search or insert
     * @return The index at which the target is found or should be inserted
     */
    public int searchInsertPositionOptimal(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int insertPosition = n; 

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= target) {
                insertPosition = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return insertPosition;
    }

    public static void main(String[] args) {
        SearchIndexPosition_1 search = new SearchIndexPosition_1();

        int[] nums = {1, 3, 5, 6};
        int target = 5;

        System.out.println("Brute Force Result: " + search.searchInsertPositionBrute(nums, target));
        System.out.println("Optimal Result: " + search.searchInsertPositionOptimal(nums, target));
    }
}
