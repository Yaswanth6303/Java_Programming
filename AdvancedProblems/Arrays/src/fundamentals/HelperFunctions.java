package fundamentals;

public class HelperFunctions {
	/**
	 * Prints the elements of the given array.
	 * 
	 * @param nums The array to be printed.
	 */
	public static void printArray(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
}
