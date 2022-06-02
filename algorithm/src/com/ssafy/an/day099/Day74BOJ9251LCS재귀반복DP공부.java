package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day74BOJ9251LCS재귀반복DP공부 {
	static char[] A, B;
	static Integer[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = (A = br.readLine().toCharArray()).length;
		int M = (B = br.readLine().toCharArray()).length;
		dp = new Integer[N][M];
		System.out.println(LCS(N - 1, M - 1));
		br.close();
	}

	private static int LCS(int r, int c) { // 재귀 top-down
		if (r == -1 || c == -1)
			return 0; // 0까지 도달 후 dp인덱스 밖이 되면 0반환종료
		if (dp[r][c] == null) {
			dp[r][c] = 0; // 탐색 도달 시 초기화

			if (A[r] == B[c])
				dp[r][c] = LCS(r - 1, c - 1) + 1; // 같은 부분이 추가되어 길이 1증가

			else
				dp[r][c] = Math.max(LCS(r - 1, c), LCS(r, c - 1));
		}
		return dp[r][c];
	}

	private static int LCS2(int N, int M) { // 반복문 bottom-up

		int[][] dp2 = new int[N + 1][M + 1];

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {

				if (A[i - 1] == B[j - 1])
					dp2[i][j] = dp2[i - 1][j - 1] + 1;

				else
					dp2[i][j] = Math.max(dp2[i - 1][j], dp2[i][j - 1]);

			}
		}

		return dp2[N][M];
	}
}
