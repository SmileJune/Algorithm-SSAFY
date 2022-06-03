package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day81BOJ2056작업DFS { // 2056 작업 - DFS 방법
	static int N, ans;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		ans = 0;
		dp = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken()); // k번째 작업에 걸리는 시간
			int p = Integer.parseInt(st.nextToken()); // 선행되는 parent 수
			dp[i] = t;
			for (int j = 0; j < p; j++)
				dp[i] = Math.max(dp[i], t + dp[Integer.parseInt(st.nextToken()) - 1]);
			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans);
		br.close();
	}
}
