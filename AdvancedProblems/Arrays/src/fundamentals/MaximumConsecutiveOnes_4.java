package fundamentals;

/**
 * A Java program to find the maximum number of consecutive 1s in a binary array.
 *
 * This class demonstrates an optimal approach using a single traversal of the array.
 *
 * Time Complexity:
 * - Best Case: O(n) — Even if the array contains all 0s or all 1s, every element must be checked.
 * - Average Case: O(n) — On average, each element is visited once.
 * - Worst Case: O(n) — Every element is visited once in the worst scenario (e.g., alternating 1s and 0s).
 *
 * Space Complexity:
 * - Optimal: O(1) — Only a few variables are used for tracking the count and max.
 * 
 */
public class MaximumConsecutiveOnes_4 {

    /**
     * Finds the maximum number of consecutive 1s in the given binary array.
     * 
     * Iterates through the array and maintains a count of consecutive 1s.
     * If a 0 is encountered, the count is reset. The maximum count encountered
     * during traversal is returned.
     * 
     * @param nums The binary array containing only 0s and 1s.
     * @return The maximum number of consecutive 1s in the array.
     */
    public int maximumConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxConsecutiveOnes = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, count);
            } else {
                count = 0;
            }
        }

        return maxConsecutiveOnes;
    }

    public static void main(String[] args) {
        MaximumConsecutiveOnes_4 maximumConsecutiveOnes_4 = new MaximumConsecutiveOnes_4();
        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0};

        System.out.println("Maximum consecutive ones in the array is: " + 
                            maximumConsecutiveOnes_4.maximumConsecutiveOnes(nums));
    }
}
