package mediumfaqs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class provides three approaches to solve the "4Sum" problem.
 * 
 * Given an array of integers and a target sum, the goal is to find all unique 
 * quadruplets (four elements) in the array that sum up to the target.
 * 
 * Three approaches are implemented:
 * 
 * 1. Brute Force Approach:
 * - Uses four nested loops to generate all combinations of four elements.
 * - Time Complexity: O(n^4) — All quadruplets are checked.
 * - Space Complexity: O(k) — Where k is the number of unique quadruplets.
 * 
 * 2. Better Approach (Hashing Based):
 * - Uses three loops and a HashSet to check if the fourth required number exists.
 * - Time Complexity: O(n^3) — Three nested loops and constant-time hash lookup.
 * - Space Complexity: O(n + k) — Extra space for hashset and unique result storage.
 * 
 * 3. Optimal Approach (Sorting + Two-Pointer):
 * - Sorts the array and uses two nested loops with a two-pointer technique to reduce complexity.
 * - Time Complexity: O(n^3) — Due to three nested iterations, but optimized via skipping duplicates.
 * - Space Complexity: O(k) — Where k is the number of unique quadruplets.
 */
public class FourSum_10 {

    /**
     * Brute force solution to find all unique quadruplets that sum up to the target.
     * 
     * Time Complexity: O(n^4)
     * Space Complexity: O(k)
     * 
     * @param nums   The input array of integers.
     * @param target The target sum to achieve.
     * @return A list of all unique quadruplets that sum to the target.
     */
    public List<List<Integer>> fourSumBrute(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> qudrapleSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(quad); // Sort to ensure uniqueness
                            qudrapleSet.add(quad);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(qudrapleSet);
    }

    /**
     * Better solution using hashing to reduce one loop.
     * 
     * Time Complexity: O(n^3)
     * Space Complexity: O(n + k)
     * 
     * @param nums   The input array of integers.
     * @param target The target sum to achieve.
     * @return A list of all unique quadruplets that sum to the target.
     */
    public List<List<Integer>> fourSumBetter(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> qudrapleSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashSet = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long fourthNumber = target - sum;

                    if (hashSet.contains(fourthNumber)) {
                        List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[k], (int) fourthNumber);
                        Collections.sort(quad);
                        qudrapleSet.add(quad);
                    }

                    hashSet.add((long) nums[k]);
                }
            }
        }

        return new ArrayList<>(qudrapleSet);
    }

    /**
     * Optimal solution using sorting and two-pointer technique.
     * 
     * Time Complexity: O(n^3)
     * Space Complexity: O(k)
     * 
     * @param nums   The input array of integers.
     * @param target The target sum to achieve.
     * @return A list of all unique quadruplets that sum to the target.
     */
    public List<List<Integer>> fourSumOptimal(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    
                    if (sum < target) {
                    	k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FourSum_10 solver = new FourSum_10();
        int[] nums = { 1, -2, 3, 5, 7, 9 };
        int target = 7;

        System.out.println("Quadruple List (Brute Force):");
        List<List<Integer>> brute = solver.fourSumBrute(nums, target);
        HelperFunctions.printListOfLists(brute);

        System.out.println("Quadruple List (Better Approach):");
        List<List<Integer>> better = solver.fourSumBetter(nums, target);
        HelperFunctions.printListOfLists(better);

        System.out.println("Quadruple List (Optimal Approach):");
        List<List<Integer>> optimal = solver.fourSumOptimal(nums, target);
        HelperFunctions.printListOfLists(optimal);
    }
}
