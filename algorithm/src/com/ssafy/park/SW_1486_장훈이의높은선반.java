package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1486_장훈이의높은선반 {
	static int N, B;
	static int[] arr;
	static int min;
	static boolean[] bo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			arr = new int[N];
			bo = new boolean[N];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			cal(N,0);
			sb.append("#" + tc + " " + (min-B) + "\n");
		}
		System.out.println(sb);
	}

	public static void cal(int n, int k) {
		if (n == k) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (bo[i]) {
					sum += arr[i];
				}
			}
			if (sum >= B) {
				min = Math.min(min, sum);
			}
			return;
		}
		bo[k] = false;
		cal(n, k + 1);
		bo[k] = true;
		cal(n, k + 1);
	}
}
