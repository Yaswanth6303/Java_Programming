package logicBuilding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fundamentals.HelperFunctions;

/**
 * A Java program to compute the union of two sorted arrays.
 * 
 * This class demonstrates two approaches:
 * 
 * - Brute Force: Using a Set to store unique elements from both arrays. -
 * Optimal: Using Two Pointer Technique to merge two sorted arrays while
 * eliminating duplicates.
 * 
 * Time Complexity: - Brute Force: O(n + m) — linear traversal of both arrays. -
 * Optimal: O(n + m) — linear traversal of both arrays using two pointers.
 * 
 * Space Complexity: - Brute Force: O(n + m) — extra space for storing elements
 * in the Set. - Optimal: O(n + m) — extra space for the result list.
 */
public class UnionOfSortedArray_4 {

	Set<Integer> set;
	List<Integer> unionList = new ArrayList<>();

	/**
	 * Constructor initializing internal data structures.
	 */
	public UnionOfSortedArray_4() {
		this.set = new HashSet<>();
		this.unionList = new ArrayList<>();
	}

	/**
	 * Computes the union of two arrays using a brute-force approach.
	 * 
	 * Adds all elements of both input arrays into a HashSet to eliminate
	 * duplicates. Finally, converts the Set into an array.
	 *
	 * @param nums1 First input array.
	 * @param nums2 Second input array.
	 * @return An array containing the union of the two input arrays.
	 */
	public int[] unionArrayBrute(int[] nums1, int[] nums2) {

		for (int num : nums1) {
			set.add(num);
		}

		for (int num : nums2) {
			set.add(num);
		}

		int[] unionArray = new int[set.size()];
		int index = 0;
		for (int num : set) {
			unionArray[index++] = num;
		}

		return unionArray;
	}

	/**
	 * Computes the union of two sorted arrays using the optimal two-pointer
	 * approach.
	 * 
	 * Traverses both arrays simultaneously, adding only distinct elements into the
	 * result list.
	 *
	 * @param nums1 First sorted input array.
	 * @param nums2 Second sorted input array.
	 * @return An array containing the union of the two input arrays.
	 */
	public int[] unionArrayOptimal(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;

		int i = 0;
		int j = 0;

		while (i < n1 && j < n2) {
			if (nums1[i] <= nums2[j]) {
				if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums1[i]) {
					unionList.add(nums1[i]);
				}
				i++;
			} else {
				if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums2[j]) {
					unionList.add(nums2[j]);
				}
				j++;
			}
		}

		while (i < n1) {
			if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums1[i]) {
				unionList.add(nums1[i]);
			}
			i++;
		}

		while (j < n2) {
			if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums2[j]) {
				unionList.add(nums2[j]);
			}
			j++;
		}

		int[] unionArray = new int[unionList.size()];
		for (int k = 0; k < unionArray.length; k++) {
			unionArray[k] = unionList.get(k);
		}

		return unionArray;
	}

	public static void main(String[] args) {
		UnionOfSortedArray_4 unionOfSortedArray_4 = new UnionOfSortedArray_4();

		int[] nums1 = { 1, 2, 3, 5 };
		int[] nums2 = { 4, 5, 6, 7, 8 };

		int[] unionArray = unionOfSortedArray_4.unionArrayBrute(nums1, nums2);
		System.out.print("Union Array (unionArrayBrute): ");
		HelperFunctions.printArray(unionArray);

		unionArray = unionOfSortedArray_4.unionArrayOptimal(nums1, nums2);
		System.out.print("Union Array (unionArrayOptimal): ");
		HelperFunctions.printArray(unionArray);
	}
}
