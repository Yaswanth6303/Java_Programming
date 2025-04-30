import java.util.HashMap;
import java.util.Map;

/**
 * This class provides three approaches to solve the problem of counting the number of subarrays with XOR equal to a given value k.
 *
 * Problem Statement:
 * Given an array of integers and an integer k, return the total number of continuous subarrays whose XOR is equal to k.
 *
 * Approaches:
 * 1. Brute Force Approach - Check all subarrays and compute XOR using three nested loops
 * 2. Better Approach - Reduce one loop by maintaining a running XOR
 * 3. Optimal Approach - Use prefix XOR and HashMap to count subarrays in O(n) time
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
 * Input: nums = [4, 2, 2, 6, 4], k = 6
 * Output: 4 (subarrays: [4,2], [2,2,6], [6], [4,2,2,6])
 */
public class CountSubArraySumXOR_4 {

    /**
     * Brute Force approach to count subarrays with XOR equal to k.
     * Uses three nested loops to consider all subarrays and compute XOR manually.
     *
     * @param nums The input array
     * @param k The target XOR value
     * @return The count of subarrays with XOR equal to k
     */
    public int subArraysWithXorKBrute(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int xor = 0;
                for (int x = i; x <= j; x++) {
                    xor ^= nums[x];
                }
                if (xor == k) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Better approach to count subarrays with XOR equal to k.
     * Uses two nested loops and maintains a running XOR.
     *
     * @param nums The input array
     * @param k The target XOR value
     * @return The count of subarrays with XOR equal to k
     */
    public int subArraysWithXorKBetter(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {
                xor ^= nums[j];
                if (xor == k) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Optimal approach to count subarrays with XOR equal to k using a HashMap.
     * Uses the concept of prefix XOR and tracks frequency of seen prefix XORs.
     *
     * @param nums The input array
     * @param k The target XOR value
     * @return The count of subarrays with XOR equal to k
     */
    public int subArraysWithXorKOptimal(int[] nums, int k) {
        int xor = 0;
        int count = 0;
        Map<Integer, Integer> prefixXorFreq = new HashMap<>();

        prefixXorFreq.put(0, 1); // base case: prefix XOR = 0 has occurred once

        for (int num : nums) {
            xor ^= num;
            int required = xor ^ k;
            count += prefixXorFreq.getOrDefault(required, 0);
            prefixXorFreq.put(xor, prefixXorFreq.getOrDefault(xor, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        CountSubArraySumXOR_4 countSubArraySumXOR = new CountSubArraySumXOR_4();
        int[] nums = {4, 2, 2, 6, 4};
        int k = 6;

        System.out.println("Input array: [4, 2, 2, 6, 4], Target XOR: 6");
        System.out.println("------------------------------------------------");

        int bruteResult = countSubArraySumXOR.subArraysWithXorKBrute(nums, k);
        System.out.println("Brute Force Result: " + bruteResult);

        int betterResult = countSubArraySumXOR.subArraysWithXorKBetter(nums, k);
        System.out.println("Better Approach Result: " + betterResult);

        int optimalResult = countSubArraySumXOR.subArraysWithXorKOptimal(nums, k);
        System.out.println("Optimal Approach Result: " + optimalResult);
    }
}
