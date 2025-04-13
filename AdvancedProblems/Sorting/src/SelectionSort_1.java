/**
 * A Java program to demonstrate Selection Sort algorithm.
 * 
 * This program sorts an array of integers in ascending order using
 * the Selection Sort technique. In each iteration, it selects the minimum
 * element from the unsorted part and swaps it with the first element
 * of the unsorted sub-array.
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */

public class SelectionSort_1 {
	
	/**
	 * Sorts the given array using Selection Sort algorithm.
	 * The array will be sorted in ascending order.
	 * 
	 * @param nums The array of integers to be sorted.
	 * @return The sorted array.
	 */
	private int[] selectionSort(int[] nums) {
		int n = nums.length;
		
        // Loop through the array. No need to check the last element,
        // as it will already be in its correct position after the loop.
		for (int i = 0; i < n - 1; i++) {
			int minimumIndex = i;
			for(int j = i + 1; j < n; j++) {
				if (nums[minimumIndex] > nums[j]) {
					minimumIndex = j;
				}
			}
			
			if (minimumIndex != i) {
				int temp = nums[i];
				nums[i] = nums[minimumIndex];
				nums[minimumIndex] = temp;
			}
		}
		
		return nums;
	}
	
	public static void main(String[] args) {
		SelectionSort_1 selectionSort_1 = new SelectionSort_1();
		int[] nums = {13, 46, 24, 52, 20, 9};
		selectionSort_1.selectionSort(nums);
		System.out.print("Sorted Array: ");
		HelperFunctions.printArray(nums);
	}
}
