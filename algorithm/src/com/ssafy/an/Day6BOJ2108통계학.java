package com.ssafy.an;

import java.util.Scanner;

public class Day6BOJ2108통계학 { // 2108
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());

		int[] cnt = new int[8001];

		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int cntMaxValue = Integer.MIN_VALUE;
		int mid = Integer.MIN_VALUE;
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(sc.nextLine());
			cnt[num + 4000]++;
			sum += num;
			if (max < num)
				max = num;
			if (min > num)
				min = num;

		}
		int cntMid = 0;
		int cntMax = 0;
		boolean flag = false;
		for (int i = min + 4000; i <= max + 4000; i++) {
			if (cnt[i] > 0) {
				if (cntMid < (N + 1) / 2) {
					cntMid += cnt[i];
					mid = i - 4000;
				}
				if (cntMaxValue < cnt[i]) {
					cntMaxValue = cnt[i];
					cntMax = i - 4000;
					flag = true;
				} else if (cntMaxValue == cnt[i] && flag == true) {
					cntMax = i - 4000;
					flag = false;
				}
			}
		}

		System.out.printf("%.0f\n", (double) sum / N);
		System.out.printf("%d\n", mid);
		System.out.printf("%d\n", cntMax);
		System.out.printf("%d\n", max - min);

		sc.close();
	}
}
