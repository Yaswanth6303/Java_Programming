package hardfaqs;

import java.util.Arrays;

/**
 * This class provides three approaches to merge two sorted arrays into one sorted array.
 * 
 * Problem Statement:
 * Given two sorted integer arrays `nums1` and `nums2`, merge `nums2` into `nums1` 
 * as one sorted array. The `nums1` array has enough space to hold additional elements from `nums2`.
 * 
 * Approaches:
 * 1. Brute Force Approach - Use an auxiliary array and merge like in merge sort
 * 2. Optimal 1 - Swap larger elements from nums1 with smaller from nums2 and sort
 * 3. Optimal 2 - Gap method similar to Shell Sort (in-place merging)
 * 
 * Time Complexities:
 * - Brute: O(m + n)
 * - Optimal 1: O(m log m + n log n)
 * - Optimal 2: O((m + n) * log(m + n))
 * 
 * Space Complexities:
 * - Brute: O(m + n)
 * - Optimal 1 and 2: O(1)
 * 
 * Example:
 * Input: nums1 = [-5, -2, 4, 5, 0, 0, 0], m = 4, nums2 = [-3, 1, 8], n = 3  
 * Output: [-5, -3, -2, 1, 4, 5, 8]
 */
public class MergeSortedArray_7 {

    /**
     * Brute force approach using extra space.
     * Merges both arrays into a new array and copies back to nums1.
     * 
     * @param nums1 First array with enough trailing space
     * @param m     Number of initialized elements in nums1
     * @param nums2 Second sorted array
     * @param n     Number of elements in nums2
     */
    public void mergeSortedArrayBrute(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[n + m];

        int left = 0;
        int right = 0;
        int index = 0;

        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                merged[index++] = nums1[left++];
            } else {
                merged[index++] = nums2[right++];
            }
        }

        while (left < m) {
            merged[index++] = nums1[left++];
        }

        while (right < n) {
            merged[index++] = nums2[right++];
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = merged[i];
        }
    }

    /**
     * Optimal approach 1.
     * Swaps larger elements from nums1 with smaller elements in nums2, 
     * then sorts both arrays individually and copies nums2 into nums1.
     * 
     * @param nums1 First array with enough trailing space
     * @param m     Number of initialized elements in nums1
     * @param nums2 Second sorted array
     * @param n     Number of elements in nums2
     */
    public void mergeSortedArrayOptimal_1(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = 0;

        while (left >= 0 && right < n) {
            if (nums1[left] > nums2[right]) {
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);

        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
    }

    /**
     * Helper method to swap elements if the first is greater than the second.
     */
    private void swapIfGreater(int[] nums1, int[] nums2, int index1, int index2) {
        if (nums1[index1] > nums2[index2]) {
            int temp = nums1[index1];
            nums1[index1] = nums2[index2];
            nums2[index2] = temp;
        }
    }

    /**
     * Optimal approach 2 (Gap Method).
     * Uses a gap technique similar to Shell Sort to compare and swap in-place.
     * 
     * @param nums1 First array with enough trailing space
     * @param m     Number of initialized elements in nums1
     * @param nums2 Second sorted array
     * @param n     Number of elements in nums2
     */
    public void mergeSortedArrayOptimal_2(int[] nums1, int m, int[] nums2, int n) {
        int length = n + m;
        int gap = (length / 2) + (length % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < length) {
                if (left < m && right >= m) {
                    swapIfGreater(nums1, nums2, left, right - m);
                } else if (left >= m) {
                    swapIfGreater(nums2, nums2, left - m, right - m);
                } else {
                    swapIfGreater(nums1, nums1, left, right);
                }
                left++;
                right++;
            }

            if (gap == 1)
                break;
            gap = (gap / 2) + (gap % 2);
        }

        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
    }

    public static void main(String[] args) {
        MergeSortedArray_7 mergeSortedArray_7 = new MergeSortedArray_7();

        int[] nums1 = new int[7];
        nums1[0] = -5;
        nums1[1] = -2;
        nums1[2] = 4;
        nums1[3] = 5;
        int[] nums2 = { -3, 1, 8 };

        System.out.print("Brute Force: ");
        mergeSortedArray_7.mergeSortedArrayBrute(nums1, 4, nums2, 3);
        HelperFunctions.printArray(nums1);

        nums1 = new int[7];
        nums1[0] = -5;
        nums1[1] = -2;
        nums1[2] = 4;
        nums1[3] = 5;
        nums2 = new int[] { -3, 1, 8 };

        System.out.print("Optimal Approach_1: ");
        mergeSortedArray_7.mergeSortedArrayOptimal_1(nums1, 4, nums2, 3);
        HelperFunctions.printArray(nums1);

        nums1 = new int[7];
        nums1[0] = -5;
        nums1[1] = -2;
        nums1[2] = 4;
        nums1[3] = 5;
        nums2 = new int[] { -3, 1, 8 };

        System.out.print("Optimal Approach_2: ");
        mergeSortedArray_7.mergeSortedArrayOptimal_2(nums1, 4, nums2, 3);
        HelperFunctions.printArray(nums1);
    }
}
