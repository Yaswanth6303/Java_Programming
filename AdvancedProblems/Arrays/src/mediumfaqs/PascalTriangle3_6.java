package mediumfaqs;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides two approaches to generate Pascal's Triangle up to a given number of rows.
 * 
 * It includes:
 * - A brute-force method using combinatorial calculation (nCr) for each element.
 * - An optimized method that generates each row iteratively from the previous element, avoiding repeated nCr calculations.
 */
public class PascalTriangle3_6 {

    /**
     * Generates Pascal's Triangle up to 'n' rows using a brute-force approach.
     * 
     * Each element is computed individually using the formula:
     * nCr = n! / (r! * (n - r)!)
     * 
     * This method uses `PascalTriangle1_4.nCr()` for combinatorial computation.
     * 
     * Time Complexity: O(n^2) * O(r) — For each row, all columns are computed via a loop.
     * Space Complexity: O(n^2) — Stores all rows in a list of lists.
     * 
     * @param n Number of rows to generate
     * @return Pascal's Triangle represented as a list of lists
     */
    public List<List<Integer>> pascalTriangle3Brute(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>(); 
        
        for(int r = 1; r <= n; r++) {
            List<Integer> pascalTriangleRow = new ArrayList<>();
            for(int c = 1; c <= r; c++) {
                pascalTriangleRow.add(PascalTriangle1_4.nCr(r - 1, c - 1));
            }
            pascalTriangle.add(pascalTriangleRow);
        }
        
        return pascalTriangle;
    }

    /**
     * Generates a single row of Pascal's Triangle based on the given row number.
     * 
     * Each value is derived from the previous value using:
     * value = previous_value * (row - column) / column
     * 
     * This avoids repeated factorial computation and improves efficiency.
     * 
     * Time Complexity: O(row) — Loop runs 'row - 1' times.
     * Space Complexity: O(row) — Stores the entire row in a list.
     * 
     * @param row Row number to generate (1-based index)
     * @return A list of integers representing the specified row
     */
    public List<Integer> generateRow(int row) {
        List<Integer> pascalList = new ArrayList<>();
        pascalList.add(1);
        
        long pascalValue = 1;
        for(int column = 1; column < row; column++) {
            pascalValue = pascalValue * (row - column);
            pascalValue = pascalValue / column;
            pascalList.add((int) pascalValue);
        }
        
        return pascalList;
    }

    /**
     * Generates Pascal's Triangle up to 'n' rows using an optimized approach.
     * 
     * This method utilizes the `generateRow` helper to compute each row iteratively,
     * reducing redundant computations compared to the brute-force nCr method.
     * 
     * Time Complexity: O(n^2) — Each row takes O(row) time.
     * Space Complexity: O(n^2) — Stores all rows in a list of lists.
     * 
     * @param n Number of rows to generate
     * @return Pascal's Triangle represented as a list of lists
     */
    public List<List<Integer>> pascalTriangle3Optimal(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>(); 
        
        for(int row = 1; row <= n; row++) {
            pascalTriangle.add(generateRow(row));
        }
        
        return pascalTriangle;
    }

    public static void main(String[] args) {
        PascalTriangle3_6 pascalTriangle3_6 = new PascalTriangle3_6();
        
        List<List<Integer>> pascalTriangleBrute = pascalTriangle3_6.pascalTriangle3Brute(5);
        HelperFunctions.printListOfLists(pascalTriangleBrute);
        
        System.out.println();
        
        List<List<Integer>> pascalTriangleOptimal = pascalTriangle3_6.pascalTriangle3Optimal(5);
        HelperFunctions.printListOfLists(pascalTriangleOptimal);
    }
}
