package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day77BOJ2293동전1DPBESTSol { // 2293 동전 1
	static int N, K;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);

		dp = new int[K + 1];
		dp[0] = 1;

		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			for (int k = a; k < K + 1; k++) {
				dp[k] += dp[k - a];
			}
		} // 입력과 동시에 사용.. 대단한 사람들..

		System.out.println(dp[K]);
		br.close();
	}
}
