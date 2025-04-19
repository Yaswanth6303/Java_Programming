package mediumfaqs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides three approaches to solve the classic "Two Sum" problem.
 * 
 * Given an array of integers and a target value, the goal is to find two
 * distinct indices whose elements add up to the target.
 * 
 * Three approaches are implemented:
 * 
 * 1. Brute Force Approach: 
 * - Checks all possible pairs using nested loops. 
 * - Time Complexity: O(n^2) — Every pair is checked once. 
 * - Space Complexity: O(1) — Constant extra space.
 * 
 * 2. Better Approach (HashMap Based): 
 * - Uses a HashMap to store visited numbers and their indices. 
 * - Time Complexity: O(n) — Single pass through the array. 
 * - Space Complexity: O(n) — Stores up to n elements in the map.
 * 
 * 3. Optimal Approach (Sorting + Two-Pointer): 
 * - Sorts the array while keeping track of original indices, then uses the two-pointer technique. 
 * - Time Complexity: O(n log n) — Sorting dominates the runtime. 
 * - Space Complexity: O(n) — Stores original indices along with values.
 */
public class TwoSum_8 {

	/**
	 * Finds two indices whose corresponding elements sum up to the target using a
	 * brute-force approach. Loops over all pairs in the array.
	 * 
	 * @param nums   The array of integers to search.
	 * @param target The target sum value.
	 * @return An array containing the two indices if found, otherwise {-1, -1}.
	 */
	public int[] twoSumBrute(int[] nums, int target) {
		int n = nums.length;
		int[] twoSumIndex = new int[2];

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums[i] + nums[j] == target) {
					twoSumIndex[0] = i;
					twoSumIndex[1] = j;
					return twoSumIndex;
				}
			}
		}

		return new int[] { -1, -1 };
	}

	/**
	 * Finds two indices whose corresponding elements sum up to the target using a
	 * HashMap for efficient lookup.
	 * 
	 * @param nums   The array of integers to search.
	 * @param target The target sum value.
	 * @return An array containing the two indices if found, otherwise {-1, -1}.
	 */
	public int[] twoSumBetter(int[] nums, int target) {
		int n = nums.length;
		int[] twoSumIndex = new int[2];
		Map<Integer, Integer> mppMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int num = nums[i];
			int moreNeeded = target - num;

			if (mppMap.containsKey(moreNeeded)) {
				twoSumIndex[0] = mppMap.get(moreNeeded);
				twoSumIndex[1] = i;
				return twoSumIndex;
			}

			mppMap.put(num, i);
		}

		return new int[] { -1, -1 };
	}

	/**
	 * Finds two indices whose corresponding elements sum up to the target using a
	 * sorting-based two-pointer approach.
	 * 
	 * Note: This approach does not preserve the original order of the array.
	 * 
	 * @param nums   The array of integers to search.
	 * @param target The target sum value.
	 * @return An array containing the two indices if found, otherwise {-1, -1}.
	 */
	public int[] twoSumOptimal(int[] nums, int target) {
		int n = nums.length;
		int[] twoSumIndex = new int[2];
		int[][] elementIndex = new int[n][2];

		for (int i = 0; i < n; i++) {
			elementIndex[i][0] = nums[i];
			elementIndex[i][1] = i;
		}

		Arrays.sort(elementIndex, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});

		int left = 0;
		int right = n - 1;

		while (left < right) {
			int sum = elementIndex[left][0] + elementIndex[right][0];

			if (sum == target) {
				twoSumIndex[0] = elementIndex[left][1];
				twoSumIndex[1] = elementIndex[right][1];
				return twoSumIndex;
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}

		return new int[] { -1, -1 };
	}

	public static void main(String[] args) {
		TwoSum_8 twoSum_8 = new TwoSum_8();
		int[] nums = { 2, 6, 5, 8, 11 };
		int target = 14;

		int[] twoSumIndexBrute = twoSum_8.twoSumBrute(nums, target);
		System.err.print("Indexes are(twoSumBrute): ");
		HelperFunctions.printArray(twoSumIndexBrute);

		int[] twoSumIndexBetter = twoSum_8.twoSumBetter(nums, target);
		System.err.print("Indexes are(twoSumBetter): ");
		HelperFunctions.printArray(twoSumIndexBetter);

		int[] twoSumIndexOptimal = twoSum_8.twoSumOptimal(nums, target);
		System.err.print("Indexes are(twoSumOptimal): ");
		HelperFunctions.printArray(twoSumIndexOptimal);
	}
}
