package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day56BOJ3040백설공주와일곱난장이DFS { // 3040 백설 공주와 일곱난장이
	static int[] arr, ans;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		ans = new int[7];
		sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());

		}
		comb(0, 0);
		br.close();
	}

	private static void comb(int d, int s) {
		if (d == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += ans[i];
				sb.append(ans[i] + "\n");
			}
			if (sum == 100) {
				System.out.println(sb);
				return;
			} else {
				sb = new StringBuilder();
				return;
			}
		}
		for (int i = s; i < 9; i++) {
			ans[d] = arr[i];
			comb(d + 1, i + 1);
		}
	}
}
