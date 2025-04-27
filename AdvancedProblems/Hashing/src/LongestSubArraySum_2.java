public class LongestSubArraySum_2 {
	public int longestSubarrayBrute(int[] nums, int k) {
        int n = nums.length; 
        int maxLength = 0;

        // starting index
        for (int startIndex = 0; startIndex < n; startIndex++) { 
            // ending index
            for (int endIndex = startIndex; endIndex < n; endIndex++) { 
                /* add all the elements of 
                   subarray = nums[startIndex...endIndex]  */
                int currentSum = 0;
                for (int i = startIndex; i <= endIndex; i++) {
                    currentSum += nums[i];
                }

                if (currentSum == k) {
                    maxLength = Math.max(maxLength, endIndex - startIndex + 1);
                }
            }
        }
        return maxLength;
    }
	public static void main(String[] args) {
		LongestSubArraySum_2 longestSubArraySum_2 = new LongestSubArraySum_2();
		int[] nums = { -1, 1, 1 };
        int k = 1;
        System.out.println(longestSubArraySum_2.longestSubarrayBrute(nums, k));
	}
}
