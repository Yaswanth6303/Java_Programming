import java.util.HashMap;
import java.util.Map;

/**
 * This class provides three approaches to solve the Longest Subarray with Sum Equals K problem.
 * 
 * Problem Statement:
 * Given an array of integers and an integer k, find the length of the longest subarray whose sum equals k.
 * 
 * Approaches:
 * 1. Brute Force Approach - Check all subarrays and their sums
 * 2. Optimal Approach (Positive and Negative Elements) - Use a HashMap to store prefix sums
 * 3. Optimal Approach (Only Positive Elements) - Use a two-pointer sliding window technique
 * 
 * Time Complexities:
 * - Brute Force: O(n^3)
 * - Optimal (Positive and Negative): O(n)
 * - Optimal (Positive Only): O(2n) ≈ O(n)
 * 
 * Space Complexities:
 * - Brute Force: O(1)
 * - Optimal (Positive and Negative): O(n)
 * - Optimal (Positive Only): O(1)
 * 
 * Example:
 * Input: nums = [-1, 1, 1], k = 1
 * Output: 2 (subarray [1,1])
 */
public class LongestSubArraySum_2 {
    
    /**
     * Brute Force approach to find the longest subarray with sum equal to k.
     * Check all possible subarrays by using three nested loops.
     *
     * @param nums The input array
     * @param k The target sum
     * @return Length of the longest subarray with sum equal to k
     */
    public int longestSubArrayBrute(int[] nums, int k) {
        int n = nums.length; 
        int maxLength = 0;

        for (int startIndex = 0; startIndex < n; startIndex++) { 
            for (int endIndex = startIndex; endIndex < n; endIndex++) { 
                int currentSum = 0;
                for (int i = startIndex; i <= endIndex; i++) {
                    currentSum += nums[i];
                }

                if (currentSum == k) {
                    maxLength = Math.max(maxLength, endIndex - startIndex + 1);
                }
            }
        }
        return maxLength;
    }

    /**
     * Optimal approach to find the longest subarray with sum equal to k.
     * Works for arrays with both positive and negative integers using HashMap to store prefix sums.
     *
     * @param nums The input array
     * @param k The target sum
     * @return Length of the longest subarray with sum equal to k
     */
    public int longestSubArrayOptimalPosAndNeg(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }

            int remainder = sum - k;
            if (prefixSumMap.containsKey(remainder)) {
                int length = i - prefixSumMap.get(remainder);
                maxLength = Math.max(maxLength, length);
            }

            if (!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, i);
            }
        }

        return maxLength;
    }

    /**
     * Optimal approach assuming all elements are positive.
     * Uses a sliding window (two-pointer) technique to find the longest subarray.
     *
     * @param nums The input array
     * @param k The target sum
     * @return Length of the longest subarray with sum equal to k
     */
    public int longestSubArrayOptimalPos(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;
        int left = 0, right = 0;
        int sum = nums[0];

        while (left <= right && right < n) {
            if (sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            
            if (sum <= k) {
                right++;
                if (right < n) {
                    sum += nums[right];
                }
            } else {
                sum -= nums[left];
                left++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubArraySum_2 longestSubArraySum_2 = new LongestSubArraySum_2();
        int[] nums = { -1, 1, 1 };
        int k = 1;

        System.out.println("Input array: [-1, 1, 1], Target Sum: 1");
        System.out.println("--------------------------------------------");

        int bruteResult = longestSubArraySum_2.longestSubArrayBrute(nums, k);
        System.out.println("Brute Force Result: " + bruteResult);

        int optimalPosNegResult = longestSubArraySum_2.longestSubArrayOptimalPosAndNeg(nums, k);
        System.out.println("Optimal Approach (Pos & Neg Elements) Result: " + optimalPosNegResult);

        int optimalPosResult = longestSubArraySum_2.longestSubArrayOptimalPos(nums, k);
        System.out.println("Optimal Approach (Positive Elements) Result: " + optimalPosResult);
    }
}
