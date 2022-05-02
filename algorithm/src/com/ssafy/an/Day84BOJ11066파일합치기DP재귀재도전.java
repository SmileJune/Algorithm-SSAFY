package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day84BOJ11066파일합치기DP재귀재도전 { // 11066 파일 합치기
	static final int INF = 1 << 30;
	static int K;
	static int[] arr, sum;
	static Integer[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine());
			arr = new int[K + 1];
			sum = new int[K + 1];
			dp = new Integer[K + 1][K + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < K + 1; i++) {
				arr[i] = Integer.parseInt(st.nextToken()); // 사용안함..
				sum[i] = sum[i - 1] + arr[i];
			} // 누적합 배열 생성

			sb.append(recur(1, K)).append("\n");
//		print(dp); // 1~K까지의 최소 비용
		}
		System.out.println(sb);
		br.close();
	}

	private static int recur(int s, int e) {
		if (s == e) // dp[i][i] = 0
			return 0;
		if (Math.abs(s - e) == 1) // dp[i][i+1] = arr[i]+arr[i+1]
			return dp[s][e] = arr[s] + arr[e];
		if (dp[s][e] != null)
			return dp[s][e]; // 이미 탐색했으면 반환
		dp[s][e] = INF; // 최소값 비교를 위한 INF
		for (int i = s; i < e; i++)
			dp[s][e] = Math.min(dp[s][e], recur(s, i) + recur(i + 1, e) + sum[e] - sum[s - 1]);
		return dp[s][e]; // s ~ i 까지, i+1 ~ e 의 합이 최소인 값 + 현재 임시파일 비용
	}

	static int pcnt = 1;

	private static void print(Integer[][] a) {
		StringBuilder tt = new StringBuilder();
		tt.append("===== " + pcnt++ + "번째 =====\n");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				tt.append((a[i][j] != null) ? a[i][j] : "n").append("\t");
			}
			tt.append("\n");
		}
		System.out.println(tt.toString());
	}
}