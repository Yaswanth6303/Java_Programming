package mediumfaqs;

/**
 * This class provides methods to compute individual elements of Pascal's Triangle.
 * 
 * Given a row and column (1-based), the method returns the value at that position.
 * Formula used: nCr = n! / (r! * (n - r)!)
 *  
 * Time Complexity: O(r) — Loop runs 'r' times.
 * Space Complexity: O(1) — Only constant extra space used.
 */
public class PascalTriangle1_4 {

    /**
     * Returns the value at row 'r' and column 'c' in Pascal's Triangle.
     * @param r Row number (1-based)
     * @param c Column number (1-based)
     * @return Value at given row and column
     */
    public int pascalTriangle1(int r, int c) {
        return nCr(r - 1, c - 1);
    }

    /**
     * Computes n choose r (nCr) using an iterative formula to avoid factorial overflows.
     * 
     * Time Complexity: O(r) — Loop runs 'r' times.
     * Space Complexity: O(1) — Uses constant extra space.
     * 
     * @param n Total number of items
     * @param r Number of items to choose
     * @return The computed nCr value
     */
    public static int nCr(int n, int r) {
        int result = 1;

        for (int i = 0; i < r; i++) {
            result = result * (n - i);
            result = result / (i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        PascalTriangle1_4 pascalTriangle1_4 = new PascalTriangle1_4();
        int pascalValue = pascalTriangle1_4.pascalTriangle1(5, 3);
        System.out.println("Value is: " + pascalValue);
    }
}
