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
	
    /**
     * Swaps two elements in the array.
     * 
     * @param nums The array where swapping is performed.
     * @param i    The index of the first element.
     * @param j    The index of the second element.
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
