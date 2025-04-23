package hardfaqs;

import java.util.ArrayList;
import java.util.List;

public class HelperFunctions {
	public static void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
	public static void printList(ArrayList<Integer> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	
	public static void printList(List<Integer> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	
	public static void printListOfLists(List<List<Integer>> listOfLists) {
	    for (List<Integer> innerList : listOfLists) {
	        for (int num : innerList) {
	            System.out.print(num + " ");
	        }
	        System.out.println(); 
	    }
	}
	public static void printMatrix(int[][] matrix) {
	    for (int i = 0; i < matrix.length; i++) {
	        for (int j = 0; j < matrix[i].length; j++) {
	            System.out.print(matrix[i][j] + " ");
	        }
	        System.out.println();
	    }
	}
}
