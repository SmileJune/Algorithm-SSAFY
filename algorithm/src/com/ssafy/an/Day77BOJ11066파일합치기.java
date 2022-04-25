package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day77BOJ11066파일합치기 { // 11066 파일 합치기  
	static final int INF = 1 << 30; // 자력아님. 한 문제 더 풀겠습니다.
	static int K;
	static int[] arr, sum;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine());
			arr = new int[K + 1];
			sum = new int[K + 1];
			dp = new int[K + 2][K + 2];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < K + 1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i - 1] + arr[i];
			}
			for (int i = 2; i < K + 1; i++) {
				for (int j = i - 1; j > 0; j--) {
					dp[j][i] = INF;
					for (int k = j; k < i + 1; k++) // 여기 노 자력..
						dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k + 1][i]);
					dp[j][i] += sum[i] - sum[j - 1];
				}
				print(dp);
			}

			sb.append(dp[1][K]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static int pcnt = 1;
	private static void print(int[][] a) {
		StringBuilder tt = new StringBuilder();
		tt.append("===== " + pcnt++ + "번째 =====\n");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				tt.append((a[i][j] != 0) ? a[i][j] : "n").append("\t");
			}
			tt.append("\n");
		}
		System.out.println(tt.toString());
	}
}
