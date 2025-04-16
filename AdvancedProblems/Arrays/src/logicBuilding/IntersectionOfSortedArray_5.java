package logicBuilding;

import java.util.ArrayList;
import java.util.List;

import fundamentals.HelperFunctions;

/**
 * A Java program to compute the intersection of two sorted arrays.
 * 
 * This class demonstrates two approaches:
 * 
 * - Brute Force using nested loops and a visited array to avoid duplicates. -
 * Optimal approach using two pointers for efficient linear comparison.
 * 
 * Time Complexity: - Brute Force: O(n1 * n2) — nested loops for each element
 * comparison. - Optimal: O(n1 + n2) — single linear pass using two pointers.
 * 
 * Space Complexity: - Brute Force: O(n2) — extra space for the visited array. -
 * Optimal: O(1) — no extra space, excluding result storage.
 * 
 * Assumptions: - Both input arrays are sorted in non-decreasing order. - The
 * result will include duplicate values if they exist in both arrays.
 */
public class IntersectionOfSortedArray_5 {

	List<Integer> intersectionListBrute;
	List<Integer> intersectionListOptimal;

	/**
	 * Constructor initializes internal lists for storing intersection results.
	 */
	public IntersectionOfSortedArray_5() {
		this.intersectionListBrute = new ArrayList<>();
		this.intersectionListOptimal = new ArrayList<>();
	}

	/**
	 * Finds the intersection of two sorted arrays using a brute-force approach.
	 * 
	 * For each element in the first array, it checks the second array to see if
	 * there is a matching element that hasn’t been visited.
	 * 
	 * @param nums1 First input sorted array.
	 * @param nums2 Second input sorted array.
	 * @return Array containing the intersection elements.
	 */
	public int[] intersectionArrayBrute(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;

		int[] visitedArray = new int[n2];

		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				if (nums1[i] == nums2[j] && visitedArray[j] == 0) {
					intersectionListBrute.add(nums1[i]);
					visitedArray[j] = 1;
					break;
				} else if (nums1[i] < nums2[j]) {
					break;
				}
			}
		}

		int[] intersectionArray = new int[intersectionListBrute.size()];
		for (int i = 0; i < intersectionArray.length; i++) {
			intersectionArray[i] = intersectionListBrute.get(i);
		}

		return intersectionArray;
	}

	/**
	 * Finds the intersection of two sorted arrays using an optimal two-pointer
	 * approach.
	 * 
	 * Moves pointers in both arrays and adds common elements to the result list,
	 * avoiding unnecessary comparisons.
	 * 
	 * @param nums1 First input sorted array.
	 * @param nums2 Second input sorted array.
	 * @return Array containing the intersection elements.
	 */
	public int[] intersectionArrayOptimal(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;

		int i = 0;
		int j = 0;

		while (i < n1 && j < n2) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				intersectionListOptimal.add(nums1[i]);
				i++;
				j++;
			}
		}

		int[] intersectionArray = new int[intersectionListOptimal.size()];
		for (int k = 0; k < intersectionArray.length; k++) {
			intersectionArray[k] = intersectionListOptimal.get(k);
		}

		return intersectionArray;
	}

	public static void main(String[] args) {
		IntersectionOfSortedArray_5 intersectionOfSortedArray_5 = new IntersectionOfSortedArray_5();
		int[] nums1 = { 1, 2, 2, 3, 5 };
		int[] nums2 = { 1, 2, 7 };

		int[] intersectionArrayBrute = intersectionOfSortedArray_5.intersectionArrayBrute(nums1, nums2);
		System.out.print("Intersection Array (intersectionArrayBrute): ");
		HelperFunctions.printArray(intersectionArrayBrute);

		int[] intersectionArrayOptimal = intersectionOfSortedArray_5.intersectionArrayOptimal(nums1, nums2);
		System.out.print("Intersection Array (intersectionArrayOptimal): ");
		HelperFunctions.printArray(intersectionArrayOptimal);
	}
}
