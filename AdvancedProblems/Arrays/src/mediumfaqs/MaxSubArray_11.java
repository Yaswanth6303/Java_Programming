package mediumfaqs;

/**
 * This class provides multiple approaches to solve the "Maximum Subarray Sum" problem.
 * 
 * Given an integer array, the task is to find the contiguous subarray with the maximum sum.
 * Several approaches are implemented:
 * 
 * 1. Brute Force Approach:
 *    - Generates all possible subarrays and computes their sums.
 *    - Time Complexity: O(n^3)
 *    - Space Complexity: O(1)
 * 
 * 2. Better Approach:
 *    - Reduces time by avoiding recomputation of subarray sums.
 *    - Time Complexity: O(n^2)
 *    - Space Complexity: O(1)
 * 
 * 3. Optimal Approach 1 (Kadane's Algorithm - Non-Negative Initial):
 *    - Handles subarrays assuming non-negative sum start, resetting to 0 on negatives.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 * 
 * 4. Optimal Approach 2 (Kadane's Algorithm - Handles Negatives):
 *    - Correctly handles cases where all numbers are negative.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 * 
 * 5. Optimal Follow-Up:
 *    - Prints the subarray that contributes to the maximum sum.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 */
public class MaxSubArray_11 {

    /**
     * Calculates the maximum subarray sum using brute-force.
     * 
     * Time Complexity: O(n^3)  
     * Space Complexity: O(1)
     * 
     * @param nums Input array of integers.
     * @return The maximum subarray sum.
     */
    public int maxSubArrayBrute(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    /**
     * Calculates the maximum subarray sum using a better approach 
     * by avoiding redundant summation.
     * 
     * Time Complexity: O(n^2)  
     * Space Complexity: O(1)
     * 
     * @param nums Input array of integers.
     * @return The maximum subarray sum.
     */
    public int maxSubArrayBetter(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    /**
     * Calculates the maximum subarray sum using Kadane's Algorithm 
     * (resets current sum to 0 on negative total).
     * 
     * Time Complexity: O(n)  
     * Space Complexity: O(1)
     * 
     * @param nums Input array of integers.
     * @return The maximum subarray sum.
     */
    public int maxSubArrayOptimal_1(int[] nums) {
        int n = nums.length;
        int maxSum = 0;
        int currSum = 0;

        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    /**
     * Calculates the maximum subarray sum using Kadane's Algorithm,
     * initialized properly to handle cases where all numbers are negative.
     * 
     * Time Complexity: O(n)  
     * Space Complexity: O(1)
     * 
     * @param nums Input array of integers.
     * @return The maximum subarray sum.
     */
    public int maxSubArrayOptimal_2(int[] nums) {
        int n = nums.length;
        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < n; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    /**
     * Calculates the maximum subarray sum and prints the subarray 
     * that gives the maximum sum.
     * 
     * Time Complexity: O(n)  
     * Space Complexity: O(1)
     * 
     * @param nums Input array of integers.
     * @return The maximum subarray sum.
     */
    public int maxSubArrayOptimalFollowUp(int[] nums) {
        int n = nums.length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int arrayStart = 0;
        int arrayEnd = 0;

        for (int i = 0; i < n; i++) {
            if (currSum == 0) {
                start = i;
            }

            currSum += nums[i];

            if (currSum > maxSum) {
                maxSum = currSum;
                arrayStart = start;
                arrayEnd = i;
            }

            if (currSum < 0) {
                currSum = 0;
            }
        }

        System.out.print("Subarray with max sum: ");
        for (int i = arrayStart; i <= arrayEnd; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArray_11 maxSubArray_11 = new MaxSubArray_11();
        int[] nums = { -1, 2, 3, -1, 2, -6, 5 };

        System.out.println("Brute Force Result: " + maxSubArray_11.maxSubArrayBrute(nums));
        System.out.println("Better Approach Result: " + maxSubArray_11.maxSubArrayBetter(nums));
        System.out.println("Optimal Approach 1 Result: " + maxSubArray_11.maxSubArrayOptimal_1(nums));
        System.out.println("Optimal Approach 2 Result: " + maxSubArray_11.maxSubArrayOptimal_2(nums));
        System.out.println("Optimal Follow-Up Result: " + maxSubArray_11.maxSubArrayOptimalFollowUp(nums));
    }
}
