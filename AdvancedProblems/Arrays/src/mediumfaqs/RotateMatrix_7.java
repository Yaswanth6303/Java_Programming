package mediumfaqs;

/**
 * This class provides methods to rotate a square matrix (n x n) by 90 degrees
 * clockwise.
 * 
 * Two approaches are implemented:
 * 
 * 1. Brute Force Approach: 
 * - Uses an extra matrix to store rotated values and then copies them back. 
 * - Time Complexity: O(n^2) — Each cell is visited once.
 * - Space Complexity: O(n^2) — Uses an auxiliary matrix for rotation.
 * 
 * 2. Optimal Approach: 
 * - Rotates the matrix in-place using two operations: 
 * 		a) Transpose the matrix. 
 * 		b) Reverse each row. 
 * - Time Complexity: O(n^2) — Each cell is visited once. 
 * - Space Complexity: O(1) — Rotation done in-place.
 */
public class RotateMatrix_7 {

	/**
	 * Rotates the matrix by 90 degrees clockwise using a brute-force approach. An
	 * extra matrix is used to store rotated elements.
	 *
	 * @param matrix The square matrix to be rotated.
	 */
	public void rotateMatrixBrute(int[][] matrix) {
		int n = matrix.length;
		int[][] rotatedMatrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rotatedMatrix[j][n - 1 - i] = matrix[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			System.arraycopy(rotatedMatrix[i], 0, matrix[i], 0, n);
		}
	}

	/**
	 * Transposes the given square matrix in-place. Transposing swaps the rows and
	 * columns.
	 * 
	 * @param matrix The square matrix to be transposed.
	 */
	public void transpose(int[][] matrix) {
		int n = matrix.length;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	/**
	 * Reverses the elements of a given 1D array in-place. Typically used to reverse
	 * a matrix row after transposing.
	 *
	 * @param nums The array to reverse.
	 */
	public void reverse(int[] nums) {
		int first_index = 0;
		int last_index = nums.length - 1;

		while (first_index < last_index) {
			int temp = nums[first_index];
			nums[first_index] = nums[last_index];
			nums[last_index] = temp;
			first_index++;
			last_index--;
		}
	}

	/**
	 * Rotates the matrix by 90 degrees clockwise using the optimal approach. First
	 * transposes the matrix, then reverses each row.
	 * 
	 * @param matrix The square matrix to be rotated.
	 */
	public void rotateMatrixOptimal(int[][] matrix) {
		transpose(matrix);
		for (int i = 0; i < matrix.length; i++) {
			reverse(matrix[i]);
		}
	}

	public static void main(String[] args) {
		RotateMatrix_7 rotateMatrix_7 = new RotateMatrix_7();

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println("Original Matrix:");
		HelperFunctions.printMatrix(matrix);

		rotateMatrix_7.rotateMatrixBrute(matrix);
		System.out.println("Rotated Matrix (rotateMatrixBrute):");
		HelperFunctions.printMatrix(matrix);

		// Reset matrix for the next rotation
		matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		rotateMatrix_7.rotateMatrixOptimal(matrix);
		System.out.println("Rotated Matrix (rotateMatrixOptimal):");
		HelperFunctions.printMatrix(matrix);
	}

}