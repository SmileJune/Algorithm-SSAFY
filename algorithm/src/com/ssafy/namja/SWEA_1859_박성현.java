package com.ssafy.namja;

import java.util.Scanner;

public class SWEA_1859_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			long[] prices = new long[N];
			for (int i = 0; i < N; i++) {
				prices[i] = sc.nextInt();
			}
			long cnt = 0;
			long total = 0;
			long benefit = 0;
			int idx = -1;
			long max_idx = maxIndex(prices, idx + 1);
			for (int i = 0; i < prices.length; i++) {
				if (i == max_idx) {
					benefit += (prices[i] * cnt - total);
					idx = i;
					cnt = 0;
					total = 0;
					max_idx = maxIndex(prices, idx + 1);
					continue;
				}
				cnt++;
				total += prices[i];
			}
			System.out.printf("#%d %d\n", t, benefit);
		}
	}

	static long maxIndex(long[] arr, long start_idx) {
		long max = 0;
		long idx = start_idx;
		for (long i = start_idx; i < arr.length; i++) {
			if (max < arr[(int) i]) {
				max = arr[(int) i];
				idx = i;
			}
		}

		return idx; // 최댓값의 인덱스 반환 예정
	}
}