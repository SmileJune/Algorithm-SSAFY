package com.ssafy.BOJ_SB;

import java.util.Scanner;

public class BOJ_2947_나무조각 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 주어진 숫자 입력받기
		int[] nums = new int[5];
		for (int i = 0; i < 5; i++) {
			nums[i] = sc.nextInt();
		}
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 4; i++) {
				if (nums[i] > nums[i + 1]) {
					int tmp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = tmp;
					for (int num : nums) {
						System.out.print(num + " ");
					}
					System.out.println();
				}
			}
		}
	}
}