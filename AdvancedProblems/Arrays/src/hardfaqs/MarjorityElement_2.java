package hardfaqs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class provides three approaches to solve the "Majority Element II" problem,
 * which finds all elements in the array that appear more than ⌊n/3⌋ times.
 * 
 * Approaches implemented:
 * 1. Brute Force
 * 2. Better (Using HashMap)
 * 3. Optimal (Modified Boyer-Moore Voting Algorithm)
 */
public class MarjorityElement_2 {

	/**
	 * Brute Force Approach:
	 * - For each element, count its frequency in the array.
	 * - If it's more than n/3 and not already in the result list, add it.
	 * 
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1) (excluding the result list)
	 */
	public List<Integer> majorityElementTwoBrute(int[] nums) {
		int n = nums.length;
		List<Integer> majorityElements = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (!majorityElements.contains(nums[i])) {
				int count = 0;

				for (int j = 0; j < n; j++) {
					if (nums[j] == nums[i]) {
						count++;
					}
				}

				if (count > n / 3) {
					majorityElements.add(nums[i]);
				}

				if (majorityElements.size() == 2) {
					break;
				}
			}
		}

		return majorityElements;
	}

	/**
	 * Better Approach:
	 * - Use a HashMap to store frequencies.
	 * - Add elements to the result list once they reach the threshold of n/3 + 1.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	public List<Integer> findMajorityElementsBetter(int[] nums) {
		int n = nums.length;

		List<Integer> majorityElements = new ArrayList<>();
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		int threshold = n / 3 + 1;

		for (int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

			if (frequencyMap.get(num) == threshold) {
				majorityElements.add(num);
			}

			if (majorityElements.size() == 2) {
				break;
			}
		}

		return majorityElements;
	}

	/**
	 * Optimal Approach (Boyer-Moore Voting Algorithm - Extended for n/3):
	 * - Since there can be at most 2 elements that appear more than n/3 times,
	 *   we keep track of two candidates and their counts.
	 * - Validate them in a second pass.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	public List<Integer> findMajorityElementsOptimal(int[] nums) {
		int n = nums.length;

		int count1 = 0;
		int count2 = 0;

		int element1 = Integer.MIN_VALUE;
		int element2 = Integer.MIN_VALUE;

		// First pass: find candidates
		for (int i = 0; i < n; i++) {
			if (nums[i] == element1) {
				count1++;
			} else if (nums[i] == element2) {
				count2++;
			} else if (count1 == 0) {
				element1 = nums[i];
				count1 = 1;
			} else if (count2 == 0) {
				element2 = nums[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}

		// Second pass: validate counts
		int occurrence1 = 0;
		int occurrence2 = 0;

		for (int num : nums) {
			if (num == element1) {
				occurrence1++;
			}
			if (num == element2) {
				occurrence2++;
			}
		}

		List<Integer> majorityElements = new ArrayList<>();
		int threshold = n / 3;

		if (occurrence1 > threshold) {
			majorityElements.add(element1);
		}
		if (occurrence2 > threshold && element1 != element2) {
			majorityElements.add(element2);
		}

		return majorityElements;
	}

	public static void main(String[] args) {
		MarjorityElement_2 majorityElement_2 = new MarjorityElement_2();

		int[] nums = { 1, 2, 1, 1, 3, 2, 2 };

		List<Integer> majorityElementsListBrute = majorityElement_2.majorityElementTwoBrute(nums);
		System.out.println("Majority Element List (Brute): " + majorityElementsListBrute);

		List<Integer> majorityElementsListBetter = majorityElement_2.findMajorityElementsBetter(nums);
		System.out.println("Majority Element List (Better): " + majorityElementsListBetter);

		List<Integer> majorityElementsListOptimal = majorityElement_2.findMajorityElementsOptimal(nums);
		System.out.println("Majority Element List (Optimal): " + majorityElementsListOptimal);
	}
}
