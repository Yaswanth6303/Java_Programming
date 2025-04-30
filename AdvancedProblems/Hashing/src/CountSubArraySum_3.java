import java.util.HashMap;
import java.util.Map;

/**
 * This class provides three approaches to solve the Subarray Sum Equals K problem.
 *
 * Problem Statement:
 * Given an array of integers and an integer k, return the total number of continuous subarrays whose sum equals to k.
 *
 * Approaches:
 * 1. Brute Force Approach - Check all subarrays and their sums using three nested loops
 * 2. Better Approach - Reduce one loop by maintaining a running sum
 * 3. Optimal Approach - Use prefix sum and hashmap to count subarrays in O(n) time
 *
 * Time Complexities:
 * - Brute Force: O(n^3)
 * - Better Approach: O(n^2)
 * - Optimal Approach: O(n)
 *
 * Space Complexities:
 * - Brute Force: O(1)
 * - Better Approach: O(1)
 * - Optimal Approach: O(n)
 *
 * Example:
 * Input: nums = [1, 2, 3], k = 3
 * Output: 2 (subarrays [1,2] and [3])
 */
public class CountSubArraySum_3 {

    /**
     * Brute Force approach to count subarrays with sum equal to k.
     * Uses three nested loops to consider all subarrays.
     *
     * @param nums The input array
     * @param k The target sum
     * @return The count of subarrays with sum equal to k
     */
    public int subArraySumBrute(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int x = i; x <= j; x++) {
                    sum += nums[x];
                }
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Better approach using two nested loops and maintaining a running sum.
     *
     * @param nums The input array
     * @param k The target sum
     * @return The count of subarrays with sum equal to k
     */
    public int subArraySumBetter(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Optimal approach using HashMap to store prefix sums and their frequencies.
     * This method achieves linear time complexity.
     *
     * @param nums The input array
     * @param k The target sum
     * @return The count of subarrays with sum equal to k
     */
    public int subArraySumOptimal(int[] nums, int k) {
        int n = nums.length;
        int currentPrefixSum = 0;
        int subArrayCount = 0;

        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // base case for subarrays starting at index 0

        for (int i = 0; i < n; i++) {
            currentPrefixSum += nums[i];
            int sumToRemove = currentPrefixSum - k;
            subArrayCount += prefixSumMap.getOrDefault(sumToRemove, 0);
            prefixSumMap.put(currentPrefixSum, prefixSumMap.getOrDefault(currentPrefixSum, 0) + 1);
        }

        return subArrayCount;
    }

    public static void main(String[] args) {
        CountSubArraySum_3 countSubArraySum = new CountSubArraySum_3();
        int[] nums = {1, 2, 3};
        int k = 3;

        System.out.println("Input array: [1, 2, 3], Target Sum: 3");
        System.out.println("------------------------------------------------");

        int bruteResult = countSubArraySum.subArraySumBrute(nums, k);
        System.out.println("Brute Force Result: " + bruteResult);

        int betterResult = countSubArraySum.subArraySumBetter(nums, k);
        System.out.println("Better Approach Result: " + betterResult);

        int optimalResult = countSubArraySum.subArraySumOptimal(nums, k);
        System.out.println("Optimal Approach Result: " + optimalResult);
    }
}
