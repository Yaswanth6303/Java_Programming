package fundamentals;

/**
 * A simple Java program to demonstrate the Linear Search algorithm.
 * 
 * Linear Search is a basic search technique that sequentially checks each element 
 * of an array until the target value is found or the list ends.
 * 
 * Time Complexity:
 * - Best Case: O(1) — when the target is at the beginning.
 * - Worst Case: O(n) — when the target is at the end or not present.
 * - Average Case: O(n).
 * 
 * Space Complexity: O(1) — no extra space required.
 * 
 */
public class LinearSearch_1 {

    /**
     * Searches for the target value in the given array using Linear Search.
     * 
     * The method iterates through the array and compares each element with the target.
     * If a match is found, it returns the index of the first occurrence.
     * If the target is not found, it returns -1.
     * 
     * @param nums The array of integers in which to search for the target.
     * @param target The value to search for in the array.
     * @return The index of the target if found; otherwise, -1.
     */
    public int linearSearch(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 3};
        int target = 3;

        LinearSearch_1 linearSearch_1 = new LinearSearch_1();
        System.out.println("Index of the target is: " + linearSearch_1.linearSearch(nums, target));
    }
}
