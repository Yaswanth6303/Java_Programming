package logicBuilding;

/**
 * A Java program to find the missing number in an array containing distinct
 * numbers from 0 to n, with one number missing.
 * 
 * This class demonstrates four approaches: - Brute Force using nested loops. -
 * Better approach using frequency array. - Optimal approach using Sum Formula.
 * - Optimal approach using XOR.
 *
 * Time Complexity: - Brute Force: O(n²) — two nested loops. - Better: O(n) —
 * two linear passes. - Optimal_1 (Sum Formula): O(n) — single linear pass. -
 * Optimal_2 (XOR): O(n) — single linear pass.
 *
 * Space Complexity: - Brute Force: O(1) — no extra space. - Better: O(n) —
 * extra space for frequency array. - Optimal_1: O(1) — no extra space. -
 * Optimal_2: O(1) — no extra space.
 * 
 */
public class MissingNumber_3 {

	/**
	 * Finds the missing number using brute-force approach.
	 * 
	 * Iterates through all numbers from 0 to n and for each number, checks whether
	 * it exists in the given array.
	 *
	 * @param nums The input array containing distinct numbers from 0 to n, except
	 *             one.
	 * @return The missing number in the array, or -1 if no number is missing.
	 */
	public int missingNumberBrute(int[] nums) {
		int n = nums.length;

		for (int i = 0; i <= n; i++) {
			boolean found = false;
			for (int j = 0; j < n; j++) {
				if (nums[j] == i) {
					found = true;
					break;
				}
			}

			if (!found) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Finds the missing number using a frequency array.
	 * 
	 * Marks each encountered number in a frequency array and identifies the missing
	 * one by checking the unmarked index.
	 *
	 * @param nums The input array containing distinct numbers from 0 to n, except
	 *             one.
	 * @return The missing number in the array, or -1 if no number is missing.
	 */
	public int missingNumberBetter(int[] nums) {
		int n = nums.length;
		int[] frequencyArray = new int[n + 1];

		for (int num : nums) {
			frequencyArray[num]++;
		}

		for (int i = 0; i <= n; i++) {
			if (frequencyArray[i] == 0) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Finds the missing number using the mathematical sum formula.
	 * 
	 * Calculates the expected total sum from 0 to n and subtracts the sum of given
	 * numbers to identify the missing number.
	 *
	 * @param nums The input array containing distinct numbers from 0 to n, except
	 *             one.
	 * @return The missing number.
	 */
	public int missingNumberOptimal_1(int[] nums) {
		int n = nums.length;
		int totalSum = (n * (n + 1) / 2);

		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		return totalSum - sum;
	}

	/**
	 * Finds the missing number using XOR approach.
	 * 
	 * Uses the property that a^a = 0 and a^0 = a, by XORing all numbers from 1 to n
	 * and all elements in the array to cancel out existing values and identify the
	 * missing one.
	 *
	 * @param nums The input array containing distinct numbers from 0 to n, except
	 *             one.
	 * @return The missing number.
	 */
	public int missingNumberOptimal_2(int[] nums) {
		int n = nums.length;
		int xor1 = 0;
		int xor2 = 0;

		for (int i = 0; i < n; i++) {
			xor1 = xor1 ^ (i + 1);
			xor2 = xor2 ^ nums[i];
		}

		return (xor1 ^ xor2);
	}

	public static void main(String[] args) {
		MissingNumber_3 missingNumber_3 = new MissingNumber_3();
		int[] nums = { 0, 1, 2, 3, 4, 5, 6, 8, 9 };

		System.out.println(
				"Missing Number in the array is (missingNumberBrute): " + missingNumber_3.missingNumberBrute(nums));
		System.out.println(
				"Missing Number in the array is (missingNumberBetter): " + missingNumber_3.missingNumberBetter(nums));
		System.out.println("Missing Number in the array is (missingNumberOptimal_1): "
				+ missingNumber_3.missingNumberOptimal_1(nums));
		System.out.println("Missing Number in the array is (missingNumberOptimal_2): "
				+ missingNumber_3.missingNumberOptimal_2(nums));
	}
}
