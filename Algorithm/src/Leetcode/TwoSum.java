package Leetcode;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		int len = nums.length;
		//두 개의 합이 target이 되는 순간 리턴한다.
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { 0, 0 };
	}

}
