package mediumfaqs;

/**
 * This class provides methods to compute and display the entire row of Pascal's Triangle
 * for a given row number (1-based).
 *
 * It includes three methods:
 * - A brute-force approach using nCr calculation
 * - An optimal in-place iterative method that prints the row
 * - An optimal method that returns the row as an array
 *
 * Time Complexity: 
 *   - O(n * r) for Brute
 *   - O(r) for Optimal_1 and Optimal_2
 * Space Complexity: 
 *   - O(1) for printing methods (Brute and Optimal_1)
 *   - O(r) for returning method (Optimal_2)
 */
public class PascalTriangle2_5 {

    /**
     * Brute-force method to print the r-th row of Pascal's Triangle using nCr formula.
     * 
     * Time Complexity: O(n * r)
     * Space Complexity: O(1)
     *
     * @param r Row number (1-based)
     */
    public void pascalTriangle2Brute_1(int r) {
        for (int c = 1; c <= r; c++) {  
            int value = PascalTriangle1_4.nCr(r - 1, c - 1);
            System.out.print(value + " "); 
        }
        System.out.println();
    }

    /**
     * Optimal method to print the r-th row of Pascal's Triangle using iterative property:
     * Each value is derived from the previous using: value = value * (r - c) / c
     * 
     * Time Complexity: O(r)
     * Space Complexity: O(1)
     *
     * @param r Row number (1-based)
     */
    public void pascalTriangle2Optimal_1(int r) {
        int pascalArray = 1;
        System.out.print(pascalArray + " ");
        for (int c = 1; c < r; c++) {
            pascalArray = pascalArray * (r - c);
            pascalArray = pascalArray / c;
            System.out.print(pascalArray + " ");
        }
        System.out.println();
    }

    /**
     * Optimal method to return the r-th row of Pascal's Triangle as an array.
     * Each element is computed iteratively from the previous using:
     * arr[c] = arr[c-1] * (r - c) / c
     * 
     * Time Complexity: O(r)
     * Space Complexity: O(r)
     *
     * @param r Row number (1-based)
     * @return An integer array containing the r-th row of Pascal's Triangle
     */
    public int[] pascalTriangle2Optimal_2(int r) {
        int[] pascalArray = new int[r];  
        pascalArray[0] = 1; 
        
        for (int c = 1; c < r; c++) {  
            pascalArray[c] = (pascalArray[c - 1] * (r - c)) / c;
        }
        
        return pascalArray;
    }

    public static void main(String[] args) {
        PascalTriangle2_5 pt = new PascalTriangle2_5();
        pt.pascalTriangle2Brute_1(6); 
        pt.pascalTriangle2Optimal_1(6);
        int[] pascalArray = pt.pascalTriangle2Optimal_2(6);
        HelperFunctions.printArray(pascalArray);
    }
}
