package hardfaqs;

/**
 * This class provides three different approaches to solve the problem of finding
 * the repeating and missing number in an array that contains numbers from 1 to n.
 * 
 * Problem Statement:
 * Given an array of size n, where one number is repeated and one number is missing,
 * find both these numbers.
 * 
 * Approaches:
 * 1. Brute Force Approach
 * 2. Better Approach using frequency array
 * 3. Optimal Approach using Mathematical Formulas
 * 
 * Time Complexities:
 * - Brute: O(n^2)
 * - Better: O(n)
 * - Optimal: O(n)
 * 
 * Space Complexities:
 * - Brute: O(1)
 * - Better: O(n)
 * - Optimal: O(1)
 * 
 * Example:
 * Input: [1, 1, 3, 4, 5]
 * Output: [1, 2] // 1 is repeating, 2 is missing
 */
public class RepeatingMissingNumber_3 {

    /**
     * Brute force approach to find the repeating and missing number.
     * Checks frequency of each number from 1 to n.
     *
     * @param nums The input array
     * @return An array with [repeatingNumber, missingNumber]
     */
    public int[] findRepeatingMissingNumberBrute(int[] nums) {
        int n = nums.length;

        int repeatingNumber = -1;
        int missingNumber = -1;

        for (int num = 1; num <= n; num++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == num) {
                    count++;
                }
            }
            if (count == 2) {
                repeatingNumber = num;
            } else if (count == 0) {
                missingNumber = num;
            }

            if (repeatingNumber != -1 && missingNumber != -1) {
                break;
            }
        }

        return new int[] { repeatingNumber, missingNumber };
    }

    /**
     * Better approach using a frequency array to find the repeating and missing number.
     *
     * @param nums The input array
     * @return An array with [repeatingNumber, missingNumber]
     */
    public int[] findRepeatingMissingNumberBetter(int[] nums) {
        int n = nums.length;

        int[] frequencyArray = new int[n + 1];

        for (int i = 0; i < n; i++) {
            frequencyArray[nums[i]]++;
        }

        int repeatingNumber = -1;
        int missingNumber = -1;

        for (int i = 1; i <= n; i++) {
            if (frequencyArray[i] == 2) {
                repeatingNumber = i;
            } else if (frequencyArray[i] == 0) {
                missingNumber = i;
            }

            if (repeatingNumber != -1 && missingNumber != -1) {
                break;
            }
        }

        return new int[] { repeatingNumber, missingNumber };
    }

    /**
     * Optimal approach using mathematical formulas to find the repeating and missing number.
     * 
     * Uses the difference between expected and actual sums and square sums.
     *
     * @param nums The input array
     * @return An array with [repeatingNumber, missingNumber]
     */
    public int[] findRepeatingMissingNumberOptimal_1(int[] nums) {
        int n = nums.length;

        // Expected sum and square sum
        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSquareSum = (long) n * (n + 1) * (2 * n + 1) / 6;

        long actualSum = 0;
        long actualSquareSum = 0;

        for (int num : nums) {
            actualSum += num;
            actualSquareSum += (long) num * (long) num;
        }

        long diffSum = actualSum - expectedSum; // x - y
        long diffSquareSum = actualSquareSum - expectedSquareSum; // x^2 - y^2

        long sumXY = diffSquareSum / diffSum;

        long repeating = (diffSum + sumXY) / 2;
        long missing = repeating - diffSum;

        return new int[] { (int) repeating, (int) missing };
    }

    /**
     * Main method to test all three approaches.
     */
    public static void main(String[] args) {
        RepeatingMissingNumber_3 repeatingMissingNumber_3 = new RepeatingMissingNumber_3();

        int[] nums = {1, 1, 3, 4, 5};

        int[] findRepeatingMissingNumberBrute = repeatingMissingNumber_3.findRepeatingMissingNumberBrute(nums);
        System.out.print("Repeating and Missing Number in the array (Brute): ");
        HelperFunctions.printArray(findRepeatingMissingNumberBrute);

        int[] findRepeatingMissingNumberBetter = repeatingMissingNumber_3.findRepeatingMissingNumberBetter(nums);
        System.out.print("Repeating and Missing Number in the array (Better): ");
        HelperFunctions.printArray(findRepeatingMissingNumberBetter);

        int[] findRepeatingMissingNumberOptimal_1 = repeatingMissingNumber_3.findRepeatingMissingNumberOptimal_1(nums);
        System.out.print("Repeating and Missing Number in the array (Optimal_1): ");
        HelperFunctions.printArray(findRepeatingMissingNumberOptimal_1);
    }
}
