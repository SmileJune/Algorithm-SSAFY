package com.ssafy.yun.pro;

public class 소수만들기 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 7, 6, 4 };
		System.out.println(solution(nums));
	}

	static public int solution(int[] nums) {
		int numOfDecimal = 0;
		for (int b = 2; b < nums.length; b++) {
			for (int a = 0; a < b - 1; a++) {
				for (int i = a + 1; i < b; i++) {
					if (checkDecimal(nums[a] + nums[b] + nums[i])) {
						numOfDecimal++;
					}
				}
			}
		}

		return numOfDecimal;

	}

	static private boolean checkDecimal(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
