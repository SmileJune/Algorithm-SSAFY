package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_8958_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sc.nextLine();
		for (int t = 1; t <= T; t++) {
			String result = sc.nextLine();
			int score = 0;
			int cnt = 0;
			for (int i = 0; i < result.length(); i++) {
				if (result.charAt(i) == 'O') {
					cnt++;
					score += cnt;
				}
				else cnt = 0;
			}
			System.out.println(score);
		}
	}
}