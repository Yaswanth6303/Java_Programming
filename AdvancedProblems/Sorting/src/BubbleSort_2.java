/**
 * A Java program to demonstrate the Bubble Sort algorithm.
 *
 * Bubble Sort is a simple comparison-based sorting technique.
 * The algorithm repeatedly steps through the list, compares adjacent elements,
 * and swaps them if they are in the wrong order. With each complete pass,
 * the largest unsorted element is "pushed" to its correct position at the end of the array.
 *
 * Time Complexity:
 * - Worst Case: O(n^2)
 * - Best Case: O(n) (if optimized with an early exit flag)
 * - Average Case: O(n^2)
 *
 * Space Complexity: O(1) (in-place sorting)
 */

public class BubbleSort_2 {
	
	/**
     * Sorts the given array in ascending order using the brute-force implementation
     * of the Bubble Sort algorithm.
     * 
     * The method iterates through the array multiple times, and in each pass,
     * adjacent elements are compared and swapped if they are not in the correct order.
     * After each pass, the largest unsorted element is placed in its correct position.
     *
     * @param nums The array of integers to be sorted.
     * @return The sorted array in ascending order.
     */
	private int[] bubbleSortBrute_1(int[] nums) {
		int n = nums.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n - 1 - i; j++) {
				if (nums[j] > nums[j + 1]) {
					HelperFunctions.swap(nums, j, j + 1);
				}
			}
		}
		
		return nums;
	}
	
	/**
     * Sorts the given array in ascending order using the brute-force implementation
     * of the Bubble Sort algorithm.
     *
     * @param nums The array of integers to be sorted.
     * @return The sorted array in ascending order.
     */
	private int[] bubbleSortBrute_2(int[] nums) {
		int n = nums.length;
		for (int i = n - 1; i >= 0; i--) {  
		    for (int j = 0; j < i; j++) {   
		        if (nums[j] > nums[j + 1]) {
		        	HelperFunctions.swap(nums, j, j + 1);
		        }
		    }
		}

		
		return nums;
	}
	
	/**
     * Sorts the given array in ascending order using the optimal implementation
     * of the Bubble Sort algorithm.
     *
     * @param nums The array of integers to be sorted.
     * @return The sorted array in ascending order.
     */
	private int[] bubbleSortOptimal(int[] nums) {
		int n = nums.length;
		for(int i = n - 1; i >= 0; i--) {
			boolean isSwapped = false;
			for(int j = 0; j <= i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					HelperFunctions.swap(nums, j, j + 1);
				}
			}
			
			if (isSwapped) {
				break;
			}
		}
		
		return nums;
	}
	
	public static void main(String[] args) {
		BubbleSort_2 bubbleSort_2 = new BubbleSort_2();
		int[] nums = {13, 46, 24, 52, 20, 9};
		bubbleSort_2.bubbleSortBrute_1(nums);
		System.out.print("Sorted Array(bubbleSortBrute_1): ");
		HelperFunctions.printArray(nums);
		bubbleSort_2.bubbleSortBrute_2(nums);
		System.out.print("Sorted Array(bubbleSortBrute_2): ");
		HelperFunctions.printArray(nums);
		bubbleSort_2.bubbleSortOptimal(nums);
		System.out.print("Sorted Array(bubbleSortOptimal): ");
		HelperFunctions.printArray(nums);
	}
}
