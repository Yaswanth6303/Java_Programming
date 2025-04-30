package fundamentals;

/**
 * This class demonstrates two approaches to find the **Lower Bound** of a target value in a sorted array.
 * 
 * Definition:
 * Lower Bound of a number `x` in a sorted array is the index of the **first element** which is **greater than or equal to `x`**.
 * If such an element doesn't exist, it returns the array size `n`.
 * 
 * Approaches:
 * 1. Brute Force - Linearly checks each element.
 * 2. Optimal - Uses Binary Search to reduce time complexity.
 * 
 * Time Complexity:
 * - Brute Force: O(n)
 * - Optimal (Binary Search): O(log n)
 */
public class LowerBound_2 {

    /**
     * Brute force method to find the lower bound.
     *
     * @param nums The sorted input array
     * @param x    The target value
     * @return The index of the first element greater than or equal to x; if not found, returns nums.length
     */
    public int lowerBoundBrute(int[] nums, int x) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] >= x) {
                return i;
            }
        }

        return n;
    }

    /**
     * Optimal method using binary search to find the lower bound.
     *
     * @param nums The sorted input array
     * @param x    The target value
     * @return The index of the first element greater than or equal to x; if not found, returns nums.length
     */
    public int lowerBoundOptimal(int[] nums, int x) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int smallestIndex = n;

        while (low <= high) {  
            int mid = low + (high - low) / 2;

            if (nums[mid] >= x) {
                smallestIndex = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return smallestIndex;
    }

    public static void main(String[] args) {
        LowerBound_2 lowerBound = new LowerBound_2();
        int[] nums = {1, 2, 4, 4, 5, 6, 8};
        int target = 4;

        int bruteResult = lowerBound.lowerBoundBrute(nums, target);
        int optimalResult = lowerBound.lowerBoundOptimal(nums, target);

        System.out.println("Brute Force Lower Bound Index: " + bruteResult);    // Expected: 2
        System.out.println("Optimal Lower Bound Index: " + optimalResult);      // Expected: 2
    }
}
