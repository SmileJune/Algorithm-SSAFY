package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파이프 옮기기
public class Day66_BOJ_G5_17070 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 점화식 만들자
		int[][][] dp = new int[N][N][3];
		dp[0][1][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 2; j < N; j++) {
				// 조건문 : 인덱스 범위 체크
				if (map[i][j] == 0) {
					dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1];
				}
				if (i - 1 >= 0 && map[i][j] == 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0) {
					dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				}
				if (i - 1 >= 0 && map[i][j] == 0) {
					dp[i][j][2] = dp[i - 1][j][0] + dp[i - 1][j][1];
				}

			}
		}
		
		int ans = dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
		System.out.println(ans);

	}
}
