package hardfaqs;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides three approaches to solve the "Majority Element" problem.
 * 
 * Given an integer array `nums`, the task is to find the majority element.
 * A majority element is an element that appears more than ⌊n / 2⌋ times.
 * If no such element exists, return -1.
 * 
 * Three approaches are implemented:
 * 
 * 1. Brute Force Approach:
 *    - For each element, count its occurrences and check if it exceeds n/2.
 *    - Time Complexity: O(n^2)
 *    - Space Complexity: O(1)
 * 
 * 2. Better Approach (Using HashMap):
 *    - Store frequencies in a map and check which element (if any) crosses n/2.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(n)
 * 
 * 3. Optimal Approach (Boyer-Moore Voting Algorithm):
 *    - Find a candidate in linear time with constant space, then verify its majority.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 */
public class MajorityElement_1 {

    /**
     * Brute Force Approach:
     * Iterates through the array and counts the occurrences of each element.
     * If an element's count is more than n/2, it is returned as the majority.
     * 
     * Time Complexity: O(n^2)  
     * Space Complexity: O(1)
     * 
     * @param nums The input array.
     * @return The majority element if present, else -1.
     */
    public int majorityElementBrute(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > n / 2) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * Better Approach (HashMap):
     * Uses a HashMap to store the frequency of each number and checks for a majority.
     * 
     * Time Complexity: O(n)  
     * Space Complexity: O(n)
     * 
     * @param nums The input array.
     * @return The majority element if present, else -1.
     */
    public int majorityElementBetter(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }

    /**
     * Optimal Approach (Boyer-Moore Voting Algorithm):
     * Finds a candidate for majority element in linear time with constant space.
     * Then verifies if the candidate is actually a majority.
     * 
     * Time Complexity: O(n)  
     * Space Complexity: O(1)
     * 
     * @param nums The input array.
     * @return The majority element if present, else -1.
     */
    public int majorityElementOptimal(int[] nums) {
        int n = nums.length;
        int count = 0;
        int element = 0;

        // Phase 1: Find a candidate
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                element = nums[i];
                count = 1;
            } else if (nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }

        // Phase 2: Verify the candidate
        int occurrence = 0;
        for (int num : nums) {
            if (num == element) {
                occurrence++;
            }
        }

        return (occurrence > n / 2) ? element : -1;
    }

    public static void main(String[] args) {
        MajorityElement_1 majorityElement_1 = new MajorityElement_1();
        int[] nums = {7, 0, 0, 1, 7, 7, 2, 7, 7};

        System.out.println("Brute Force Result: " + majorityElement_1.majorityElementBrute(nums));
        System.out.println("HashMap Result: " + majorityElement_1.majorityElementBetter(nums));
        System.out.println("Boyer-Moore Result: " + majorityElement_1.majorityElementOptimal(nums));
    }
}
