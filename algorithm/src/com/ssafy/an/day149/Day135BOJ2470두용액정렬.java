package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day135BOJ2470두용액정렬 { // 2470 두 용액 정렬
	static int N, L, R;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		solve(0, N - 1);

		System.out.println(L + " " + R);
		br.close();
	}

	static void solve(int l, int r) {
		int max = 2000000000;

		while (l < r) {
			int sum = arr[l] + arr[r];

			// 두 용액 갱신
			if (Math.abs(sum) < max) {
				L = arr[l];
				R = arr[r];
				max = Math.abs(sum);
			}

			if (sum > 0)
				r--;
			else
				l++;
		}
	}
}
