package mediumfaqs;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A Java program to identify all "leader" elements in a given array.
 * 
 * An element is considered a leader if it is strictly greater than all the
 * elements to its right. The rightmost element is always a leader by
 * definition.
 * 
 * This class demonstrates two approaches:
 * 
 * - Brute Force: Compares each element with all the elements to its right. -
 * Optimal: Traverses from right to left, maintaining the maximum encountered so
 * far.
 * 
 * Time Complexity: - Brute Force: O(n^2) — nested loops for every pair
 * comparison. - Optimal: O(n) — single pass from right to left.
 * 
 * Space Complexity: - Both approaches: O(k) — where `k` is the number of
 * leaders found.
 */
public class LeaderInArray_1 {

	/**
	 * Finds leaders in the array using a brute-force approach.
	 * 
	 * For each element, checks all elements to its right to verify if it's larger
	 * than every one of them. If so, the element is considered a leader.
	 * 
	 * @param nums Input array of integers.
	 * @return An ArrayList containing all leader elements.
	 */
	public ArrayList<Integer> leadersBrute(int[] nums) {

		ArrayList<Integer> leaderListBrute = new ArrayList<>();

		int n = nums.length;

		for (int i = 0; i < n; i++) {
			boolean leader = true;
			for (int j = i + 1; j < n; j++) {
				if (nums[j] >= nums[i]) {
					leader = false;
					break;
				}
			}

			if (leader) {
				leaderListBrute.add(nums[i]);
			}
		}

		return leaderListBrute;
	}

	/**
	 * Finds leaders in the array using an optimal approach.
	 * 
	 * The algorithm traverses the array from right to left, maintaining the maximum
	 * value seen so far. Any element greater than this maximum is considered a
	 * leader. The final list is reversed to maintain the original order.
	 * 
	 * @param nums Input array of integers.
	 * @return An ArrayList containing all leader elements.
	 */
	public ArrayList<Integer> leadersOptimal(int[] nums) {

		ArrayList<Integer> leaderListOptimal = new ArrayList<>();

		int n = nums.length;

		if (n == 0) {
			return leaderListOptimal;
		}

		int max = nums[n - 1];
		leaderListOptimal.add(nums[n - 1]);

		for (int i = n - 2; i >= 0; i--) {
			if (nums[i] > max) {
				leaderListOptimal.add(nums[i]);
				max = nums[i];
			}
		}

		Collections.reverse(leaderListOptimal);

		return leaderListOptimal;
	}

	public static void main(String[] args) {
		LeaderInArray_1 leaderInArray_1 = new LeaderInArray_1();
		int[] nums = { 1, 2, 5, 3, 1, 2 };

		ArrayList<Integer> leadersBrute = leaderInArray_1.leadersBrute(nums);
		System.out.print("Leaders in Array (leadersBrute): ");
		HelperFunctions.printList(leadersBrute);

		ArrayList<Integer> leadersOptimal = leaderInArray_1.leadersOptimal(nums);
		System.out.print("Leaders in Array (leadersOptimal): ");
		HelperFunctions.printList(leadersOptimal);
	}
}
