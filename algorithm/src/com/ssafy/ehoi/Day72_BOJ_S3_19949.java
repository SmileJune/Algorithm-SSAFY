package com.ssafy.ehoi;

import java.util.Arrays;
import java.util.Scanner;

public class Day72_BOJ_S3_19949 {
	static int sel[], ans[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ans = new int[10];
		for (int i = 0; i < 10; i++)
			ans[i] = sc.nextInt();

		sel = new int[10]; // 답안지
		cnt = 0;

		perm(0);

		System.out.println(cnt);

		sc.close();
	}

	private static void perm(int cnt) {
		// 10문제 다 찍었으면
		if (cnt == 10) {
			// 매겨봐야지
			count();
			return;
		}

		for (int i = 1; i <= 5; i++) {
			if (cnt >= 2 && sel[cnt - 2] == i && sel[cnt - 1] == i )
				continue;
			sel[cnt] = i;
			perm(cnt + 1);
		}

	}

	static int cnt;

	private static void count() {
		// 5점 이상이면 cnt++
		int score = 0;
		for (int i = 0; i < 10; i++) {
			if (ans[i] == sel[i])
				score++;
		}
		if (score >= 5)
			cnt++;
	}

}
