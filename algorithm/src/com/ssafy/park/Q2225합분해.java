package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2225합분해 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			arr[i] = i;
		}
		int[][] dp = new int[cnt + 1][N + 1];
		for (int i = 1; i <= cnt; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= cnt; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = ((dp[i][j - 1] + dp[i - 1][j]) % 1000000000);
			}
		}
		System.out.println(dp[cnt][N]);
	}
}
