/**
 * QuickSort_5 demonstrates the Quick Sort algorithm.
 * 
 * Quick Sort is a Divide and Conquer algorithm:
 * - It selects a pivot element.
 * - Partitions the array such that elements smaller than the pivot go to the left,
 *   and elements greater than the pivot go to the right.
 * - Recursively applies the same strategy to the subarrays.
 * 
 * Time Complexity:
 * Best / Average: O(n log n)  
 * Worst: O(n^2) when the array is already sorted (or pivot selection is poor).
 */
public class QuickSort_5 {

    /**
     * Method to sort an array using Quick Sort.
     * 
     * @param nums The unsorted integer array.
     * @return The sorted integer array.
     */
    private int[] quickSort(int[] nums) {
        int n = nums.length;
        quickSortHelper(nums, 0, n - 1);
        return nums;
    }

    /**
     * Recursive helper that applies Quick Sort to subarrays.
     * 
     * @param nums The array being sorted.
     * @param low  The starting index of the subarray.
     * @param high The ending index of the subarray.
     */
    private void quickSortHelper(int[] nums, int low, int high) {
        if (low < high) {
            int partitionIndex = partitionIndex(nums, low, high);
            quickSortHelper(nums, low, partitionIndex - 1);
            quickSortHelper(nums, partitionIndex + 1, high);
        }
    }

    /**
     * Partitions the array around a pivot so that:
     * - Elements <= pivot are moved to the left.
     * - Elements > pivot are moved to the right.
     * 
     * The pivot is chosen as the first element of the subarray.
     * 
     * @param nums The array being sorted.
     * @param low  The start index of the subarray.
     * @param high The end index of the subarray.
     * @return The final index of the pivot element after partition.
     */
    private int partitionIndex(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (nums[i] <= pivot && i <= high - 1) {
                i++;
            }
            while (nums[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
            	HelperFunctions.swap(nums, i, j);
            }
        }
        HelperFunctions.swap(nums, low, j);
        return j;
    }


    public static void main(String[] args) {
        QuickSort_5 quickSort_5 = new QuickSort_5();
        int[] nums = { 3, 1, 2, 4, 1, 5, 2, 6, 4 };
        quickSort_5.quickSort(nums);
        System.out.print("Sorted Array: ");
        HelperFunctions.printArray(nums);
    }
}
