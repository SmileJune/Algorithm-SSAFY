package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day95BOJ11052카드구매DP { //
	static int N;
	static int[] arr;
	static Integer[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new Integer[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(recur(N));
		br.close();
	}

	private static int recur(int n) {
		if (dp[n] == null) {
			dp[n] = arr[n];
			for (int i = 1; i < n; i++)
				dp[n] = Math.max(dp[n], recur(n - i) + arr[i]);
		}
//		System.out.println(Arrays.toString(dp));
		return dp[n];
	}
}
// n = i + (n - i), n개를 구매하는 방법
// 중에 값이 최대일때를 반환한다.
// 예제1 )
// 4 
// 1 5 6 7
// dp[4] = dp[4] 또는 dp[3]+arr[1] 또는 dp[2]+arr[2] 또는 dp[1]+arr[3]
// dp[3] = dp[3] 또는 dp[2]+arr[1] 또는 dp[1]+arr[2]
// dp[2] = dp[2] 또는 dp[1]+arr[1]
// dp[1] = dp[1]
