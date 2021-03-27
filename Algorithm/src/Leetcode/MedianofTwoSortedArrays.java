package Leetcode;

import java.util.Arrays;

public class MedianofTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int nums1len = nums1.length;
		int nums2len = nums2.length;
		
		//새 배열을 생성에 두 배열을 합친다.
		int[] nums = new int[nums1len + nums2len];
		System.arraycopy(nums2, 0, nums, 0, nums2len);
		System.arraycopy(nums1, 0, nums, nums2len, nums1len);

		//합친 배열들을 정렬한다.
		Arrays.sort(nums);

		int numslen = nums.length;
		
		//중간 값을 구해서 리턴한다.
		if (numslen % 2 == 1 || numslen == 1) {
			return (double) nums[numslen / 2];
		} else {
			return (double) (nums[numslen / 2] + nums[numslen / 2 - 1]) / 2;
		}
	}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
