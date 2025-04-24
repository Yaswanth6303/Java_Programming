package hardfaqs;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides two approaches to solve the Reverse Pairs problem.
 * 
 * Problem Statement:
 * Given an array of integers, count the number of reverse pairs.
 * A reverse pair is defined as (i, j) where 0 <= i < j < n and nums[i] > 2 * nums[j].
 * 
 * Approaches:
 * 1. Brute Force Approach - Check all pairs
 * 2. Optimal Approach - Modified Merge Sort
 * 
 * Time Complexities:
 * - Brute: O(n^2)
 * - Optimal: O(2n * log n)
 * 
 * Space Complexities:
 * - Brute: O(1)
 * - Optimal: O(n) for temporary array during merge
 * 
 * Example:
 * Input: [6, 4, 4, 2, 2]
 * Output: 6
 */
public class ReversePairs_5 {

    /**
     * Brute force approach to count reverse pairs.
     * Compares each element with every other element after it.
     * 
     * @param nums The input array
     * @return Number of reverse pairs
     */
    public int reversePairsBrute(int[] nums) {
        int n = nums.length;
        int countPairs = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > 2 * nums[j]) {
                    countPairs++;
                }
            }
        }

        return countPairs;
    }

    /**
     * Helper method to merge two sorted subarrays.
     * 
     * @param nums The array to be sorted
     * @param low The starting index
     * @param mid The midpoint index
     * @param high The ending index
     */
    private void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }

        while (left <= mid) {
            temp.add(nums[left++]);
        }

        while (right <= high) {
            temp.add(nums[right++]);
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    /**
     * Counts the number of reverse pairs across the two halves.
     * 
     * @param nums The input array
     * @param low The starting index
     * @param mid The midpoint index
     * @param high The ending index
     * @return Number of reverse pairs between the two halves
     */
    private int countPairs(int[] nums, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;

        for (int i = low; i <= mid; i++) {
            while (right <= high && nums[i] > 2L * nums[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }

        return count;
    }

    /**
     * Modified merge sort that counts reverse pairs while sorting.
     * 
     * @param nums The array to be sorted
     * @param low Starting index
     * @param high Ending index
     * @return Number of reverse pairs in the range
     */
    private int mergeSort(int[] nums, int low, int high) {
        int count = 0;

        if (low >= high) {
            return count;
        }

        int mid = low + (high - low) / 2;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);

        return count;
    }

    /**
     * Optimal approach using modified merge sort to count reverse pairs.
     * 
     * @param nums The input array
     * @return Number of reverse pairs
     */
    public int reversePairsOptimal(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }

    public static void main(String[] args) {
        ReversePairs_5 reversePairs_5 = new ReversePairs_5();
        int[] nums = { 6, 4, 4, 2, 2 };

        System.out.println("Brute Force Output: " + reversePairs_5.reversePairsBrute(nums));
        System.out.println("Optimal Approach Output: " + reversePairs_5.reversePairsOptimal(nums));
    }
}
