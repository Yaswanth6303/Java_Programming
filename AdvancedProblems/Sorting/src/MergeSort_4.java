import java.util.ArrayList;
import java.util.List;

/**
 * A Java program to demonstrate the Merge Sort algorithm.
 *
 * Merge Sort is a classic Divide and Conquer algorithm that splits the array 
 * into halves, recursively sorts each half, and then merges the sorted halves 
 * to produce the final sorted array.
 *
 * Time Complexity:
 * - Best, Average, Worst Case: O(n log n)
 *
 * Space Complexity: O(n) (requires temporary storage for merging).
 */
public class MergeSort_4 {

    /**
     * An ArrayList to store merged elements temporarily during the merging phase.
     * Must be cleared before each merge operation.
     */
    List<Integer> arrayList;

    /**
     * Constructor for initializing the helper ArrayList.
     */
    public MergeSort_4() {
        arrayList = new ArrayList<Integer>();
    }

    /**
     * Method to sort the given array using Merge Sort.
     *
     * @param nums The unsorted array of integers.
     * @return The sorted array.
     */
    private int[] mergeSort(int[] nums) {
        int n = nums.length;
        mergeSortHelper(nums, 0, n - 1);
        return nums;
    }

    /**
     * Helper method that recursively divides the array into halves and sorts them.
     *
     * @param nums The array to be sorted.
     * @param low  The starting index of the current segment.
     * @param high The ending index of the current segment.
     */
    private void mergeSortHelper(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSortHelper(nums, low, mid);
        mergeSortHelper(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    /**
     * Merges two sorted subarrays into a single sorted segment.
     * Subarrays: nums[low...mid] and nums[mid+1...high].
     *
     * @param nums The array containing the subarrays to merge.
     * @param low  The starting index of the left subarray.
     * @param mid  The ending index of the left subarray.
     * @param high The ending index of the right subarray.
     */
    private void merge(int[] nums, int low, int mid, int high) {
        arrayList.clear(); // Clear the list before merging.

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                arrayList.add(nums[left]);
                left++;
            } else {
                arrayList.add(nums[right]);
                right++;
            }
        }

        // Copy remaining elements from left subarray
        while (left <= mid) {
            arrayList.add(nums[left]);
            left++;
        }

        // Copy remaining elements from right subarray
        while (right <= high) {
            arrayList.add(nums[right]);
            right++;
        }

        // Copy merged elements back into the original array
        for (int i = low; i <= high; i++) {
            nums[i] = arrayList.get(i - low);
        }
    }

    public static void main(String[] args) {
        MergeSort_4 mergeSort_4 = new MergeSort_4();
        int[] nums = { 3, 1, 2, 4, 1, 5, 2, 6, 4 };
        mergeSort_4.mergeSort(nums);
        System.out.print("Sorted Array: ");
        HelperFunctions.printArray(nums);
    }
}
