package logicBuilding;

import fundamentals.HelperFunctions;

/**
 * A Java program to shift all zeroes in an array to the end while maintaining
 * the relative order of the non-zero elements.
 * 
 * This class demonstrates three approaches to solving the "Move Zeroes"
 * problem: - Brute Force - Optimal using two-pointer swap - Optimal using
 * overwrite and fill method
 *
 * Time Complexity: - Brute Force: O(n) — Two passes: one to collect non-zeroes,
 * another to write them back. - Optimal_1: O(n) — Single pass for swapping. -
 * Optimal_2: O(n) — Single pass for placing non-zeroes and another to fill
 * zeroes.
 *
 * Space Complexity: - Brute Force: O(n) — Uses an extra array. - Optimal_1:
 * O(1) — In-place swapping. - Optimal_2: O(1) — In-place overwrite.
 * 
 */
public class MoveZeroes_1 {

	/**
	 * Moves all zeroes to the end of the array using a brute force method.
	 * 
	 * It first copies all non-zero elements into a temporary array, then copies
	 * them back into the original array followed by zeroes.
	 * 
	 * @param nums The array where zeroes need to be moved.
	 */
	public void moveZeroesBrute(int[] nums) {
		int n = nums.length;
		int[] nonZeroArray = new int[n];
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (nums[i] != 0) {
				nonZeroArray[count] = nums[i];
				count++;
			}
		}

		for (int i = 0; i < count; i++) {
			nums[i] = nonZeroArray[i];
		}

		for (int i = count; i < n; i++) {
			nums[i] = 0;
		}
	}

	/**
	 * Moves all zeroes to the end of the array using an optimal two-pointer swap
	 * technique.
	 * 
	 * It identifies the first zero, and then swaps it with the next non-zero value
	 * encountered. This method modifies the array in-place.
	 * 
	 * @param nums The array where zeroes need to be moved.
	 */
	public void moveZeroesOptimal_1(int[] nums) {
		int n = nums.length;
		int j = -1;

		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				j = i;
				break;
			}
		}

		if (j == -1) {
			return;
		}

		for (int i = j + 1; i < n; i++) {
			if (nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j++;
			}
		}
	}

	/**
	 * Moves all zeroes to the end of the array using an overwrite and fill
	 * technique.
	 * 
	 * First, all non-zero elements are moved to the front of the array, then the
	 * remaining positions are filled with zeroes.
	 * 
	 * @param nums The array where zeroes need to be moved.
	 */
	public void moveZeroesOptimal_2(int[] nums) {
		int n = nums.length;
		int j = 0;

		for (int i = 0; i < n; i++) {
			if (nums[i] != 0) {
				nums[j] = nums[i];
				j++;
			}
		}

		while (j < n) {
			nums[j] = 0;
			j++;
		}
	}

	public static void main(String[] args) {
		MoveZeroes_1 moveZeroes_1 = new MoveZeroes_1();
		int[] nums = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };

		System.out.print("Sorted Array: ");
		moveZeroes_1.moveZeroesBrute(nums);
		HelperFunctions.printArray(nums);

		System.out.print("Sorted Array: ");
		moveZeroes_1.moveZeroesOptimal_1(nums);
		HelperFunctions.printArray(nums);

		System.out.print("Sorted Array: ");
		moveZeroes_1.moveZeroesOptimal_2(nums);
		HelperFunctions.printArray(nums);
	}
}
