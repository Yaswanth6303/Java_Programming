package mediumfaqs;

import java.util.Arrays;

/**
 * This class provides three approaches to solve the "Sort an Array of 0s, 1s and 2s" problem.
 * 
 * Given an array consisting only of 0s, 1s, and 2s, the task is to sort it in linear time without using any extra sorting function.
 * 
 * Three approaches are implemented:
 * 
 * 1. Brute Force Approach:
 *    - Uses the built-in `Arrays.sort()` method.
 *    - Time Complexity: O(n log n)
 *    - Space Complexity: O(1)
 * 
 * 2. Better Approach (Counting Sort):
 *    - Counts the number of 0s, 1s, and 2s, then fills the array accordingly.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 * 
 * 3. Optimal Approach (Dutch National Flag Algorithm):
 *    - Uses three pointers: low, mid, and high to sort the array in a single pass.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 */
public class SortArray012_11 {

    /**
     * Sorts the array using the built-in Java sorting function (Brute Force).
     * 
     * Time Complexity: O(n log n)  
     * Space Complexity: O(1)
     * 
     * @param nums The input array consisting only of 0s, 1s, and 2s.
     */
    public void sortZeroOneTwoBrute(int[] nums) {
        Arrays.sort(nums);
    }

    /**
     * Sorts the array using the counting sort technique.
     * Counts the occurrences of 0s, 1s, and 2s, then rewrites the array accordingly.
     * 
     * Time Complexity: O(n)  
     * Space Complexity: O(1)
     * 
     * @param nums The input array consisting only of 0s, 1s, and 2s.
     */
    public void sortZeroOneTwoBetter(int[] nums) {
        int n = nums.length;

        int count_0 = 0;
        int count_1 = 0;
        int count_2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) count_0++;
            else if (nums[i] == 1) count_1++;
            else count_2++;
        }

        for (int i = 0; i < count_0; i++) {
            nums[i] = 0;
        }

        for (int i = count_0; i < count_0 + count_1; i++) {
            nums[i] = 1;
        }

        for (int i = count_0 + count_1; i < n; i++) {
            nums[i] = 2;
        }
    }

    /**
     * Sorts the array using the Dutch National Flag algorithm (Optimal).
     * Uses three pointers to sort the array in a single pass.
     * 
     * Time Complexity: O(n)  
     * Space Complexity: O(1)
     * 
     * @param nums The input array consisting only of 0s, 1s, and 2s.
     */
    public void sortZeroOneTwoOptimal(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    /**
     * Main method to test the sorting functions on a sample input.
     */
    public static void main(String[] args) {
        SortArray012_11 sortArray012_11 = new SortArray012_11();
        int[] nums = {0, 2, 1, 2, 0, 1};

        System.out.print("Sorted Array(sortZeroOneTwoBrute): ");
        sortArray012_11.sortZeroOneTwoBrute(nums);
        HelperFunctions.printArray(nums);

        System.out.print("Sorted Array(sortZeroOneTwoBetter): ");
        sortArray012_11.sortZeroOneTwoBetter(nums);
        HelperFunctions.printArray(nums);

        System.out.print("Sorted Array(sortZeroOneTwoOptimal): ");
        sortArray012_11.sortZeroOneTwoOptimal(nums);
        HelperFunctions.printArray(nums);
    }
}
