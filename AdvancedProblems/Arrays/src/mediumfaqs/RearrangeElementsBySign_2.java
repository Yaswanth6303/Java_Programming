package mediumfaqs;

import java.util.ArrayList;
import java.util.List;

/**
 * A Java program to rearrange the elements of an array so that: - Positive and
 * negative integers are placed alternately. - The order starts with a positive
 * number at index 0.
 *
 * This class demonstrates two approaches:
 * 
 * - Brute Force: Separates positives and negatives into two lists, then interleaves them. 
 * - Optimal: Uses extra space but fills positive and negative numbers directly into even and odd indices in a single traversal.
 *
 * Assumption: 
 * - The number of positive and negative integers is always equal.
 *
 * Time Complexity: 
 * - Both approaches: O(n) — single-pass separation and placement.
 * 
 * Space Complexity: 
 * - Brute Force: O(n) — for two separate lists. 
 * - Optimal: O(n) — for the rearranged result array.
 */
public class RearrangeElementsBySign_2 {

	/**
	 * Rearranges the array so that positive and negative elements appear
	 * alternately using a brute-force approach.
	 *
	 * Steps: 
	 * - Separates all positive and negative numbers into two lists. 
	 * - Reconstructs the original array by placing positive numbers at even indices
	 * and negative numbers at odd indices.
	 *
	 * @param nums Input array of integers (equal count of positives and negatives
	 *             assumed).
	 * @return Rearranged array with alternating positive and negative elements.
	 */
	public int[] rearrangeArrayBrute(int[] nums) {
		int n = nums.length;

		List<Integer> postiveIntegers = new ArrayList<>();
		List<Integer> negativeIntegers = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				postiveIntegers.add(nums[i]);
			} else {
				negativeIntegers.add(nums[i]);
			}
		}

		for (int i = 0; i < n / 2; i++) {
			nums[2 * i] = postiveIntegers.get(i);
			nums[2 * i + 1] = negativeIntegers.get(i);
		}

		return nums;
	}

	/**
	 * Rearranges the array so that positive and negative elements appear
	 * alternately using an optimal approach.
	 *
	 * Steps: 
	 * - Traverses the original array once. 
	 * - Places positive numbers at even indices and negative numbers at odd indices.
	 *
	 * @param nums Input array of integers (equal count of positives and negatives
	 *             assumed).
	 * @return A new rearranged array with alternating positive and negative
	 *         elements.
	 */
	public int[] rearrangeArrayOptmial(int[] nums) {
		int n = nums.length;

		int postiveIndex = 0;
		int negativeIndex = 1;

		int[] rearrangeArray = new int[n];

		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				rearrangeArray[postiveIndex] = nums[i];
				postiveIndex += 2;
			} else {
				rearrangeArray[negativeIndex] = nums[i];
				negativeIndex += 2;
			}
		}

		return rearrangeArray;
	}

	public static void main(String[] args) {
		RearrangeElementsBySign_2 rearrangeElementsBySign_2 = new RearrangeElementsBySign_2();
		int[] nums = { 2, 4, 5, -1, -3, -4 };

		int[] rearrageElementsArrayBrute = rearrangeElementsBySign_2.rearrangeArrayBrute(nums);
		System.out.print("Rearranged Elements in the array (rearrangeArrayBrute): ");
		HelperFunctions.printArray(rearrageElementsArrayBrute);

		int[] rearrageElementsArrayOptimal = rearrangeElementsBySign_2.rearrangeArrayOptmial(nums);
		System.out.print("Rearranged Elements in the array (rearrangeArrayOptimal): ");
		HelperFunctions.printArray(rearrageElementsArrayOptimal);
	}
}
