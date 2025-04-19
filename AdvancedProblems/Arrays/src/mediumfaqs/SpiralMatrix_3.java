package mediumfaqs;

import java.util.ArrayList;
import java.util.List;

/**
 * A Java program to return the elements of a 2D matrix in spiral order,
 * starting from the top-left corner and traversing clockwise.
 *
 * Example Input:
 * [
 *  [1, 2, 3, 4],
 *  [5, 6, 7, 8],
 *  [9, 10, 11, 12],
 *  [13, 14, 15, 16]
 * ]
 *
 * Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
 *
 * Time Complexity: O(m * n), where m = rows and n = columns. 
 * Space Complexity: O(1) (excluding the result list).
 */
public class SpiralMatrix_3 {

	/**
	 * Returns the elements of the given matrix in spiral order.
	 *
	 * @param matrix A 2D array of integers.
	 * @return A list of integers representing the matrix elements in spiral order.
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> spiralList = new ArrayList<>();

		int m = matrix[0].length;
		int n = matrix.length;

		int left = 0;
		int top = 0;
		int right = m - 1;
		int bottom = n - 1;

		while (left <= right && top <= bottom) {

			// Traverse from Left to Right
			for (int i = left; i <= right; i++) {
				spiralList.add(matrix[top][i]);
			}
			top++;

			// Traverse from Top to Bottom
			for (int i = top; i <= bottom; i++) {
				spiralList.add(matrix[i][right]);
			}
			right--;

			// Traverse from Right to Left (if applicable)
			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					spiralList.add(matrix[bottom][i]);
				}
				bottom--;
			}

			// Traverse from Bottom to Top (if applicable)
			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					spiralList.add(matrix[i][left]);
				}
				left++;
			}
		}

		return spiralList;
	}

	public static void main(String[] args) {
		SpiralMatrix_3 spiralMatrix_3 = new SpiralMatrix_3();
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        
		List<Integer> spiralList = spiralMatrix_3.spiralOrder(matrix);
		HelperFunctions.printList(spiralList);
	}
}
