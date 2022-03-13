package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_1500_박성현 {
		static int max = 0;
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

			int S = sc.nextInt(); // K <= S <= 100
			int K = sc.nextInt(); // K <= 20
			int[] nums = new int[K];
			int remain = S % K;
			for (int i = 0; i < K; i++) {
				nums[i] = S / K;
			}
			for (int i = 0; i < remain; i++) {
				nums[i]++;
			}
			
			long ans = 1;
			for (int i = 0; i < K; i++) {
				ans *= nums[i];
			}
			System.out.println(ans);
		}
	}
