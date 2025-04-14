package fundamentals;

/**
 * A Java program to perform a left rotation of an array by one position.
 *
 * This class demonstrates how to shift each element one step to the left
 * and move the first element to the end of the array.
 *
 * Time Complexity:
 * - Best Case: O(n) — All elements need to be shifted even if they are already in order.
 * - Average Case: O(n) — Linear traversal and shift for any general input.
 * - Worst Case: O(n) — Still linear even in the worst case (e.g., sorted in reverse).
 *
 * Space Complexity:
 * - Optimal: O(1) — No extra space is used except for a temporary variable.
 * 
 */
public class LeftRotateArrayByOne_5 {

    /**
     * Rotates the given array to the left by one position.
     * 
     * The first element is stored temporarily, all other elements are shifted
     * one index to the left, and the stored element is placed at the end.
     * 
     * @param nums The array to be rotated.
     */
    public void rotateArrayByOne(int[] nums) {
        int n = nums.length;
        int temp = nums[0];

        for (int i = 1; i < n; i++) {
            nums[i - 1] = nums[i];
        }

        nums[n - 1] = temp;
    }

    public static void main(String[] args) {
        LeftRotateArrayByOne_5 leftRotateArrayByOne_5 = new LeftRotateArrayByOne_5();
        int[] nums = {1, 2, 3, 4, 5};

        leftRotateArrayByOne_5.rotateArrayByOne(nums);

        // Helper function assumed to print array elements
        HelperFunctions.printArray(nums);
    }
}
