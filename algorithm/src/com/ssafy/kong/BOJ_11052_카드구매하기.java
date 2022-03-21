package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11052_카드구매하기 {
	static int N;
	static int[] card;
	static int[] dp;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		card = new int[N + 1];
		dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i - j] + card[j]);
			}
		}

		System.out.println(dp[N]);
	}

}
