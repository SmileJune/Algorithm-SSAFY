package com.ssafy.yun.pro;

import java.util.Arrays;

public class 폰켓몬 {
	public static void main(String[] args) {
		int[] nums = { 3, 3, 3, 2, 2, 4 };
		System.out.println(solution(nums));
	}

	public static int solution(int[] nums) {

		int possibleMaxNumber = nums.length / 2;

		return checkMaxNumber(possibleMaxNumber, nums);
	}

	static int checkMaxNumber(int possibleMaxNumber, int[] nums) {

		Arrays.sort(nums);
		int lastNumberChecked = nums[0];
		int maxNumber = 1;

		for (int i = 1; i < nums.length; i++) {
			if (possibleMaxNumber == maxNumber) {
				return possibleMaxNumber;
			}

			if (nums[i] != lastNumberChecked) {
				lastNumberChecked = nums[i];
				maxNumber++;
			} else {
				continue;
			}
		}
		return maxNumber;
	}
}
