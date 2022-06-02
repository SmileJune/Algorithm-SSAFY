package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Day73BOJ2565전깃줄DP공부 {
	static int N, ans;
	static int[][] list;
	static Integer[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		ans = 0;
		list = new int[N][2];
		dp = new Integer[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, recur(i));
		}

		System.out.println(N - ans);
		br.close();
	}

	private static int recur(int n) {
		if (dp[n] == null) { // Integer타입으로 dp사용할때 장점
			dp[n] = 1;
			for (int i = n + 1; i < N; i++) {
				if (list[n][1] < list[i][1])
					dp[n] = Math.max(dp[n], recur(i) + 1);
			}
		} // LIS 길이나 갯수 문제를 풀때 자주 보이는 구성, 이미지로 익히자
		return dp[n];
	}
}
