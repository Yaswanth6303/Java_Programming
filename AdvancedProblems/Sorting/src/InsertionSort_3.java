/**
 * A Java program to demonstrate the Insertion Sort algorithm.
 *
 * Insertion Sort is an efficient algorithm for sorting a small number of elements.
 * It builds the sorted array one element at a time by comparing the current element
 * with its predecessors and inserting it into its correct position.
 *
 * Time Complexity:
 * - Worst Case: O(n^2) when the array is in reverse order.
 * - Best Case: O(n) when the array is already sorted.
 * - Average Case: O(n^2).
 *
 * Space Complexity: O(1) (in-place sorting).
 */

public class InsertionSort_3 {
	
	/**
     * Sorts the given array in ascending order using the Insertion Sort algorithm.
     *
     * The algorithm iterates through the array, and for each element,
     * it shifts the sorted portion to the right until the correct position is found,
     * then places the element at that position.
     *
     * @param nums The array of integers to be sorted.
     * @return The sorted array in ascending order.
     */
	private int[] insertionSort(int[] nums) {
		int n = nums.length;
		
		for(int i = 0; i < n; i++) {
			int j = i;
			while (j > 0 && nums[j - 1] > nums[j]) {
				HelperFunctions.swap(nums, j, j - 1);
				j--;
			}
		}
		return nums;
	}
	public static void main(String[] args) {
		InsertionSort_3 insertionSort_3 = new InsertionSort_3();
		int[] nums = {13, 46, 24, 52, 20, 9};
		insertionSort_3.insertionSort(nums);
		System.out.print("Sorted Array: ");
		HelperFunctions.printArray(nums);
	}
}
