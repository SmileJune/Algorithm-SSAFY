package com.ssafy.namja;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2005_박성현 {

	static int[] prev_nums;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			System.out.printf("#%d\n", t);
			for (int i = 0; i < N; i++) {
				int[] nums = new int[i + 1];

				nums[0] = 1;
				if (i >= 2) {
					for (int j = 1; j < i; j++)
						nums[j] = prev_nums[j - 1] + prev_nums[j];
				}
				nums[i] = 1;
				prev_nums = Arrays.copyOf(nums, i + 1);

				for (int j = 0; j <= i; j++)
					System.out.printf("%d ", nums[j]);
				System.out.println();
			}
		}
	}
}