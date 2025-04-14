package fundamentals;

/**
 * The {@code LeftRotateArrayByK_6} class provides multiple approaches to rotate
 * an array to the left by 'k' positions.
 * <p>
 * It demonstrates three methods:
 * <ul>
 * <li><b>Brute Force Approach 1:</b> Create a new array and shift elements
 * directly.</li>
 * <li><b>Brute Force Approach 2:</b> Use a temporary array for the first 'k'
 * elements, shift the rest, then place the saved elements at the end.</li>
 * <li><b>Optimal Approach:</b> Reverse the parts of the array in place for O(1)
 * extra space.</li>
 * </ul>
 * Time Complexity: O(n) for all approaches.<br>
 * Space Complexity: Varies — O(n) for brute force methods, O(1) for the optimal
 * approach.
 */
public class LeftRotateArrayByK_6 {

	/**
	 * Rotates the given array to the left by 'k' positions using the brute force
	 * method. This method creates a new rotated array and returns it.
	 *
	 * @param nums The original array.
	 * @param k    Number of positions to rotate.
	 * @return The rotated array.
	 */
	public int[] rotateArrayBrute_1(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		int[] rotatedArray = new int[n];
		int j = 0;

		// Copy last (n - k) to start of new array
		for (int i = k; i < n; i++) {
			rotatedArray[j++] = nums[i];
		}

		// Copy first k to end
		for (int i = 0; i < k; i++) {
			rotatedArray[j++] = nums[i];
		}

		return rotatedArray;
	}

	/**
	 * Rotates the given array to the left by 'k' positions using the brute force
	 * method. This method modifies the original array directly using a temporary
	 * array.
	 *
	 * @param nums The original array to be rotated.
	 * @param k    Number of positions to rotate.
	 */
	public void rotateArrayBrute_2(int[] nums, int k) {
		int n = nums.length;
		k = k % n;

		int[] temp = new int[k];

		// Step 1: Store first k elements
		for (int i = 0; i < k; i++) {
			temp[i] = nums[i];
		}

		// Step 2: Shift the rest left
		for (int i = k; i < n; i++) {
			nums[i - k] = nums[i];
		}

		// Step 3: Copy temp to end
		for (int i = n - k; i < n; i++) {
			nums[i] = temp[i - (n - k)];
		}
	}

	/**
	 * Reverses the elements of the array from the given start index to end index.
	 *
	 * @param nums  The array to reverse.
	 * @param start The starting index.
	 * @param end   The ending index.
	 */
	public void reverseArray(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	/**
	 * Rotates the given array to the left by 'k' positions using the optimal
	 * in-place reversal method.
	 *
	 * @param nums The original array to be rotated.
	 * @param k    Number of positions to rotate.
	 */
	public void rotateArrayOptimal(int[] nums, int k) {
		int n = nums.length;
		k = k % n;

		// Step 1: Reverse first k
		reverseArray(nums, 0, k - 1);

		// Step 2: Reverse remaining
		reverseArray(nums, k, n - 1);

		// Step 3: Reverse all
		reverseArray(nums, 0, n - 1);
	}

	public static void main(String[] args) {
		LeftRotateArrayByK_6 leftRotateArrayByK_6 = new LeftRotateArrayByK_6();
		int[] original = { 1, 2, 3, 4, 5, 6 };
		int k = 2;

		int[] nums1 = original.clone();
		int[] rotatedArray = leftRotateArrayByK_6.rotateArrayBrute_1(nums1, k);
		System.out.println("Rotated Array (rotateArrayBrute_1): ");
		HelperFunctions.printArray(rotatedArray);

		int[] nums2 = original.clone();
		leftRotateArrayByK_6.rotateArrayBrute_2(nums2, k);
		System.out.println("Rotated Array (rotateArrayBrute_2): ");
		HelperFunctions.printArray(nums2);

		int[] nums3 = original.clone();
		leftRotateArrayByK_6.rotateArrayOptimal(nums3, k);
		System.out.println("Rotated Array (rotateArrayOptimal): ");
		HelperFunctions.printArray(nums3);
	}
}
