package logicBuilding;

/**
 * This class provides methods to find the floor and ceiling of a target value in a sorted array.
 *
 * Problem Statement:
 * Given a sorted array of integers and a target value, find:
 * - Floor: The greatest element in the array less than or equal to the target.
 * - Ceil: The smallest element in the array greater than or equal to the target.
 *
 * Approaches:
 * Both operations use binary search to achieve optimal performance.
 *
 * Time Complexity: O(log n) for both floor and ceil operations
 * Space Complexity: O(1)
 *
 * Example:
 * Input: sortedArray = [1, 2, 4, 6, 10, 12], target = 5
 * Output: Floor = 4, Ceil = 6
 */
public class FloorCeilSortedArray_2 {

    /**
     * Finds the floor of the target value in a sorted array.
     *
     * @param nums   The sorted input array
     * @param n      The length of the array
     * @param target The target value
     * @return The floor value, or -1 if no such value exists
     */
    private int findFloor(int[] nums, int n, int target) {
        int start = 0;
        int end = n - 1;
        int floorValue = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] <= target) {
                floorValue = nums[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return floorValue;
    }

    /**
     * Finds the ceil of the target value in a sorted array.
     *
     * @param nums   The sorted input array
     * @param n      The length of the array
     * @param target The target value
     * @return The ceil value, or -1 if no such value exists
     */
    private int findCeil(int[] nums, int n, int target) {
        int start = 0;
        int end = n - 1;
        int ceilValue = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= target) {
                ceilValue = nums[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ceilValue;
    }

    /**
     * Returns both the floor and ceil of a given target value in a sorted array.
     *
     * @param sortedArray The sorted input array
     * @param targetValue The target value
     * @return An array where index 0 is the floor and index 1 is the ceil
     */
    public int[] getFloorAndCeil(int[] sortedArray, int targetValue) {
        int arrayLength = sortedArray.length;

        int floor = findFloor(sortedArray, arrayLength, targetValue);
        int ceil = findCeil(sortedArray, arrayLength, targetValue);

        return new int[] { floor, ceil };
    }

    public static void main(String[] args) {
        FloorCeilSortedArray_2 floorCeilSortedArray_2 = new FloorCeilSortedArray_2();

        int[] sortedArray = {1, 2, 4, 6, 10, 12};
        int targetValue = 5;

        int[] result = floorCeilSortedArray_2.getFloorAndCeil(sortedArray, targetValue);
        System.out.println("Floor: " + result[0] + ", Ceil: " + result[1]);
    }
}
