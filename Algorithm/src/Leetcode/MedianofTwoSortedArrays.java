package Leetcode;

import java.util.Arrays;

public class MedianofTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int nums1len = nums1.length;
		int nums2len = nums2.length;

		// 새 배열을 생성에 두 배열을 합친다.
		int[] nums = new int[nums1len + nums2len];
		System.arraycopy(nums2, 0, nums, 0, nums2len);
		System.arraycopy(nums1, 0, nums, nums2len, nums1len);

		// 합친 배열들을 정렬한다.
		Arrays.sort(nums);

		int numslen = nums.length;

		// 중간 값을 구해서 리턴한다.
		if (numslen % 2 == 1 || numslen == 1) {
			return (double) nums[numslen / 2];
		} else {
			return (double) (nums[numslen / 2] + nums[numslen / 2 - 1]) / 2;
		}
	}

	public double findMedianSortedArrays_2(int[] nums1, int[] nums2) {
		int nums1len = nums1.length;
		int nums2len = nums2.length;
		int numslen = (nums1len + nums2len) / 2+1;

		// 새 배열을 생성에 두 배열을 합친다.
		int[] nums = new int[numslen];
		int nums1_idx = 0, nums2_idx = 0, nums_idx = 0;
		// 둘 배열을 합쳐도 값을 하나만 가지고 있을경우
		if (numslen == 1) {
			if (nums1len == 0) {
				return (double) nums2[0];
			} else {
				return (double) nums1[0];
			}

		} else {
			while (nums_idx != numslen) {
				if (nums1_idx == nums1len) { //둘 중 하나의 인덱스라도 끝에 도달하면 다른 배열만 가져온다.
					nums[nums_idx++] = nums2[nums2_idx++];
				} else if (nums2_idx == nums2len) { //둘 중 하나의 인덱스라도 끝에 도달하면 다른 배열만 가져온다.
					nums[nums_idx++] = nums1[nums1_idx++];
				} else {//두 배열을 비교하여 더 작은 값을 가져온다.
					if (nums1[nums1_idx] < nums2[nums2_idx]) {
						nums[nums_idx++] = nums1[nums1_idx++];
					} else if (nums1[nums1_idx] > nums2[nums2_idx]) {
						nums[nums_idx++] = nums2[nums2_idx++];
					} else {//두 값이 같을 경우.
						nums[nums_idx++] = nums1[nums1_idx++];
                        if(nums_idx!=numslen){
						    nums[nums_idx++] = nums2[nums2_idx++];
                        }
					}
				}
			}
		}
		
		if ((nums1len + nums2len) % 2 == 1) {
			return (double) nums[numslen-1];
		} else {
			return (double) (nums[numslen - 1] + nums[numslen-2]) / 2;
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
