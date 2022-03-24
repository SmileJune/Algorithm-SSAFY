package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_2480_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] dice = new int[7];
		for (int i = 0; i < 3; i++)
			dice[sc.nextInt()]++;

		int max = 0;
		for (int i = 0; i <= 6; i++) {
			max = Math.max(max, dice[i]);
		}

		for (int i = 6; i >= 0; i--) {
			if (max == 1) {
				if (dice[i] == max) {
					System.out.println(i * 100);
					break;
				}
			} else if (max == 2 || max == 3) {
				if (dice[i] == max) {
					System.out.println((int)(10 * Math.pow(10, max) + i * Math.pow(10, max)));
					break;
				}
			}
		}
	}
}