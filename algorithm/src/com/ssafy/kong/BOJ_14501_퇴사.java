package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
	static int N;
	static int[][] work;
	static int ans;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		work = new int[N + 2][2];
		dp = new int[N + 2];
		for (int i = 1; i <= N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			work[i][0] = Integer.parseInt(st.nextToken()); // 걸리는 일수
			work[i][1] = Integer.parseInt(st.nextToken()); // 비용
		}
		for (int i = N; i > 0; --i) {
			int day = i + work[i][0];
			if (day <= N + 1) {
				dp[i] = Math.max(dp[i + 1], dp[day] + work[i][1]);
			} else {
				dp[i] = dp[i + 1];
			}
		}
		System.out.println(dp[1]);

	}

//	static  find(int idx) {
//		
//	}
}