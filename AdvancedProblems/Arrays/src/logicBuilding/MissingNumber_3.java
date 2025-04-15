package logicBuilding;

public class MissingNumber_3 {
	public int missingNumberBrute(int[] nums) {
		int n = nums.length;
		
		for (int i = 0; i <= n; i++) {
			int flag = 0;
			for(int j = 0; j < n; j++) {
				if (nums[j] == i) {
					flag = 1;
					break;
				}
			}
			
			if (flag == 0) {
				return i;
			}
		}
		
		return -1;
	}
	public int missingNumberBetter(int[] nums) {
		int n = nums.length;
		
		int[] frequencyArray = new int[n + 1];
		
		for (int num : nums) {
			frequencyArray[num]++;
		}
		
		for (int i = 0; i <= n; i++) {
			if (frequencyArray[i] == 0) {
				return i;
			}
		}
		
		return -1;
	}
	public int missingNumberOptimal_1(int[] nums) {
		int n = nums.length;
		
		int totalSum = (n * (n + 1) / 2);
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += nums[i];
		}
		
		int missingNumber = totalSum - sum;
		
		return missingNumber;
	}
	public static void main(String[] args) {
		MissingNumber_3 missingNumber_3 = new MissingNumber_3();
		int[] nums = {0, 1, 2, 3, 4, 5, 6, 8, 9};
		System.out.println("Missing Number in the arrays is(missingNumberBrute): " + missingNumber_3.missingNumberBrute(nums));
		System.out.println("Missing Number in the arrays is(missingNumberBetter): " + missingNumber_3.missingNumberBetter(nums));
		System.out.println("Missing Number in the arrays is(missingNumberOptimal_1): " + missingNumber_3.missingNumberOptimal_1(nums));
	}
}
