package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_2484_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int ans_t = 0;
		for (int t = 0; t < T; t++) {
			int[] dice = new int[7];
			for (int i = 0; i < 4; i++)
				dice[sc.nextInt()]++;
			int ans = 0;
			int max = 0;
			int cnt = 0;
			for (int i = 0; i <= 6; i++) {
				max = Math.max(max, dice[i]);
				if (dice[i] == 2)
					cnt++;
			}

			for (int i = 6; i >= 0; i--) {
				if (max == 1) {
					if (dice[i] == max) {
						ans = i * 100;
						break;
					}
				} else if (max == 2) {
					if (dice[i] == max) {
						if (cnt == 2)
							ans += 1000 + i * 500;
						else {
							ans = 1000 + i * 100;
							break;
						}
					}
				} else if (max == 3) {
					if (dice[i] == max) {
						ans = 10000 + i * 1000;
						break;
					}
				} else if (max == 4) {
					if (dice[i] == max) {
						ans = 50000 + i * 5000;
						break;
					}
				}
			}
			ans_t = Math.max(ans, ans_t);
		}
		System.out.println(ans_t);
	}
}
