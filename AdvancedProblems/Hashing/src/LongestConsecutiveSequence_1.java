import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class provides three approaches to solve the Longest Consecutive Sequence problem.
 * 
 * Problem Statement:
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * The consecutive sequence must be made of numbers appearing one after another (not necessarily adjacent in the array).
 * 
 * Approaches:
 * 1. Brute Force Approach - For each element, check if the next elements exist
 * 2. Better Approach - Sort the array and then count consecutive elements
 * 3. Optimal Approach - Use a HashSet to efficiently find consecutive sequences
 * 
 * Time Complexities:
 * - Brute: O(n^2)
 * - Better: O(n log n)
 * - Optimal: O(n)
 * 
 * Space Complexities:
 * - Brute and Better: O(1) extra space
 * - Optimal: O(n) extra space for HashSet
 * 
 * Example:
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4 (because sequence is [1, 2, 3, 4])
 */
public class LongestConsecutiveSequence_1 {
    
    /**
     * Helper method that checks if a given target exists in the array.
     *
     * @param nums The input array
     * @param target The number to search for
     * @return True if the target exists, otherwise false
     */
    private boolean existsInArray(int[] nums, int target) {
        for (int element : nums) {
            if (element == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * Brute force approach to find the longest consecutive sequence.
     * For each element, linearly search for the next consecutive elements.
     * 
     * @param nums The input array
     * @return Length of the longest consecutive sequence
     */
    public int longestConsecutiveBrute(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            int currentElement = nums[i];
            int currentLength = 1;

            while (existsInArray(nums, currentElement + 1)) {
                currentElement += 1;
                currentLength++;
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }

    /**
     * Better approach that sorts the array and counts consecutive elements.
     * Handles duplicate elements carefully.
     * 
     * @param nums The input array
     * @return Length of the longest consecutive sequence
     */
    public int longestConsecutiveBetter(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int maxLength = 1;
        int count = 0;
        int lastSmaller = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == lastSmaller) {
                count++;
                lastSmaller = nums[i];
            } else if (nums[i] != lastSmaller) {
                count = 1;
                lastSmaller = nums[i];
            }
            
            maxLength = Math.max(maxLength, count);
        }

        return maxLength;
    }
    
    /**
     * Optimal approach using HashSet to find the longest consecutive sequence.
     * Only starts counting when the current number is the start of a sequence.
     * 
     * @param nums The input array
     * @return Length of the longest consecutive sequence
     */
    public int longestConsecutiveOptimal(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        Set<Integer> elements = new HashSet<>();
        for (int num : nums) {
            elements.add(num);
        }

        int maxLength = 1;

        for (int num : elements) {
            if (!elements.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                while (elements.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }


    public static void main(String[] args) {
        LongestConsecutiveSequence_1 sequenceFinder = new LongestConsecutiveSequence_1();
        
        int[] nums = {100, 4, 200, 1, 3, 2};
        
        System.out.println("Input array: " + Arrays.toString(nums));
        System.out.println("--------------------------------------------");

        int bruteResult = sequenceFinder.longestConsecutiveBrute(nums);
        System.out.println("Brute Force Result: " + bruteResult);

        int betterResult = sequenceFinder.longestConsecutiveBetter(nums);
        System.out.println("Better Approach (Sort + Scan) Result: " + betterResult);

        int optimalResult = sequenceFinder.longestConsecutiveOptimal(nums);
        System.out.println("Optimal Approach (HashSet) Result: " + optimalResult);
    }
}
