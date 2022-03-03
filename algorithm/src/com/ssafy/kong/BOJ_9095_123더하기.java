package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_123더하기 {
	static int N;
	static int ans;
	static int dp[] = new int[11];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp[1] = 1; // 초기 값 초기화
		dp[2] = 2;
		dp[3] = 4;

		for (int j = 4; j <= 10; j++) { // 4부터 반복
			dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1];
		}

		for (int i = 0; i < T; i++) {
			int n = N = Integer.parseInt(br.readLine());

			System.out.println(dp[n]);
		}
	}
}
