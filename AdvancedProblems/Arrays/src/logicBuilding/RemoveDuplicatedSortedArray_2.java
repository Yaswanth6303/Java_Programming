package logicBuilding;

import java.util.Set;
import java.util.TreeSet;

/**
 * A Java program to remove duplicates from a sorted array.
 * 
 * This class demonstrates two approaches:
 * - Brute Force using a TreeSet.
 * - Optimal solution using two-pointer technique.
 *
 * Time Complexity:
 * - Brute Force: O(n log n) + O(n) — inserting elements into a TreeSet.
 * - Optimal: O(n) — single linear pass through the array.
 *
 * Space Complexity:
 * - Brute Force: O(n) — extra space for the TreeSet.
 * - Optimal: O(1) — in-place modification.
 * 
 */
public class RemoveDuplicatedSortedArray_2 {

    /**
     * Removes duplicates from a sorted array using a brute-force approach.
     * 
     * Utilizes a TreeSet to store unique elements in sorted order,
     * and overwrites the original array.
     *
     * @param nums The sorted input array with possible duplicates.
     * @return The number of unique elements after removal.
     */
    public int removeDuplicatesBrute(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        
        // Insert elements into TreeSet to automatically remove duplicates and sort
        for (int num : nums) {
            set.add(num);
        }

        int j = 0;
        for (int integer : set) {
            nums[j] = integer;
            j++;
        }

        return set.size();
    }

    /**
     * Removes duplicates from a sorted array using the optimal two-pointer approach.
     * 
     * Modifies the array in-place to contain only unique elements at the start.
     *
     * @param nums The sorted input array with possible duplicates.
     * @return The number of unique elements after removal.
     */
    public int removeDuplicatesOptimal(int[] nums) {
        if (nums.length == 0) return 0;

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {           
                nums[j + 1] = nums[i];
                j++;
            }
        }
        return j + 1; // number of unique elements
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 3};
        RemoveDuplicatedSortedArray_2 removeDuplicatedSortedArray_2 = new RemoveDuplicatedSortedArray_2();

        int lengthBrute = removeDuplicatedSortedArray_2.removeDuplicatesBrute(nums);
        System.out.println("Brute Force Unique Count: " + lengthBrute);

        int[] nums2 = {1, 1, 2, 2, 2, 3, 3};
        int lengthOptimal = removeDuplicatedSortedArray_2.removeDuplicatesOptimal(nums2);
        System.out.println("Optimal Unique Count: " + lengthOptimal);
    }
}
