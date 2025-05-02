package logicBuilding;

public class FirstLastXOccurence_3 {
	public int[] searchRangeBrute(int[] nums, int target) {
		int n = nums.length;
		int firstIndex = -1;
		int lastIndex = -1;
		
		for(int i = 0; i < n; i++) {
			if (nums[i] == target) {
				if (firstIndex == -1) {
					firstIndex = i;
				}
				lastIndex = i;
			}
		}
		
		return new int[] { firstIndex, lastIndex };
	}
	
	public static void main(String[] args) {
		
	}
}
