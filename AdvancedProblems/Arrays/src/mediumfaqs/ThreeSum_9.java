package mediumfaqs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class provides three approaches to solve the classic "3Sum" problem.
 * 
 * Given an array of integers, the goal is to find all unique triplets whose
 * elements add up to zero.
 * 
 * Three approaches are implemented:
 * 
 * 1. Brute Force Approach: 
 * - Checks all possible triplets using three nested loops. 
 * - Time Complexity: O(n^3) — Every combination is checked. 
 * - Space Complexity: O(k) — Where k is the number of unique triplets.
 * 
 * 2. Better Approach (Hashing Based): 
 * - Uses a HashSet to improve the lookup for the third required element. 
 * - Time Complexity: O(n^2) — Two loops and constant-time lookups. 
 * - Space Complexity: O(n) — Extra space for the hashset.
 * 
 * 3. Optimal Approach (Sorting + Two-Pointer): 
 * - Sorts the array first, then applies the two-pointer technique. 
 * - Time Complexity: O(n^2) — Sorting dominates initial cost, then two nested loops. 
 * - Space Complexity: O(k) — Where k is the number of unique triplets.
 */
public class ThreeSum_9 {

	/**
	 * Finds all unique triplets in the array that sum up to zero using brute force.
	 * Loops over all possible triplets and stores only unique sorted triplets.
	 * 
	 * Time Complexity: O(n^3) 
	 * Space Complexity: O(k) where k is the number of unique triplets.
	 * 
	 * @param nums The input array of integers.
	 * @return A list containing all unique triplets that sum to zero.
	 */
	public List<List<Integer>> threeSumBrute(int[] nums) {
		int n = nums.length;
		Set<List<Integer>> tripletSet = new HashSet<>();

		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> tripletList = Arrays.asList(nums[i], nums[j], nums[k]);
						Collections.sort(tripletList); // Sort to ensure uniqueness in the set.
						tripletSet.add(tripletList);
					}
				}
			}
		}
		return new ArrayList<>(tripletSet);
	}

	/**
	 * Finds all unique triplets in the array that sum up to zero using hashing. For
	 * each element, uses a HashSet to check for the third complement.
	 * 
	 * Time Complexity: O(n^2) 
	 * Space Complexity: O(n) — Additional space for the HashSet.
	 * 
	 * @param nums The input array of integers.
	 * @return A list containing all unique triplets that sum to zero.
	 */
	public List<List<Integer>> threeSumBetter(int[] nums) {
		int n = nums.length;
		Set<List<Integer>> tripletSet = new HashSet<>();

		for (int i = 0; i < n; i++) {
			Set<Integer> hashSet = new HashSet<>();
			for (int j = i + 1; j < n; j++) {
				int thirdElement = -(nums[i] + nums[j]);
				if (hashSet.contains(thirdElement)) {
					List<Integer> tripletList = Arrays.asList(nums[i], nums[j], thirdElement);
					Collections.sort(tripletList); // Sort to ensure uniqueness in the set.
					tripletSet.add(tripletList);
				}
				hashSet.add(nums[j]);
			}
		}
		return new ArrayList<>(tripletSet);
	}

	/**
	 * Finds all unique triplets in the array that sum up to zero using the optimal
	 * approach. First sorts the array, then applies the two-pointer technique to
	 * efficiently identify valid triplets while avoiding duplicates.
	 * 
	 * Time Complexity: O(n^2) Space Complexity: O(k) — Where k is the number of
	 * unique triplets.
	 * 
	 * @param nums The input array of integers.
	 * @return A list containing all unique triplets that sum to zero.
	 */
	public List<List<Integer>> threeSumOptimal(int[] nums) {
		int n = nums.length;
		List<List<Integer>> tripletList = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < n; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue; // Skip duplicates for the first element.

			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];

				if (sum > 0) {
					k--;
				} else if (sum < 0) {
					j++;
				} else {
					tripletList.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;

					while (j < k && nums[j] == nums[j - 1])
						j++; // Skip duplicates for the second element.
					while (j < k && nums[k] == nums[k + 1])
						k--; // Skip duplicates for the third element.
				}
			}
		}
		return tripletList;
	}

	public static void main(String[] args) {
	    ThreeSum_9 threeSum = new ThreeSum_9();
	    int[] nums = { -1, 0, 1, 2, -1, -4 };

	    // Brute Force Approach
	    List<List<Integer>> tripletsBrute = threeSum.threeSumBrute(nums);
	    System.out.println("Unique triplets (Brute Force):");
	    for (List<Integer> triplet : tripletsBrute) {
	        System.out.println(triplet);
	    }

	    // Better Approach (Hashing)
	    List<List<Integer>> tripletsBetter = threeSum.threeSumBetter(nums);
	    System.out.println("\nUnique triplets (Better Approach - Hashing):");
	    for (List<Integer> triplet : tripletsBetter) {
	        System.out.println(triplet);
	    }

	    // Optimal Approach (Sorting + Two Pointers)
	    List<List<Integer>> tripletsOptimal = threeSum.threeSumOptimal(nums);
	    System.out.println("\nUnique triplets (Optimal Approach - Two Pointers):");
	    for (List<Integer> triplet : tripletsOptimal) {
	        System.out.println(triplet);
	    }
	}

}
