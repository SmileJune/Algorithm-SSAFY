package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day67BOJ1932정수삼각형 { // 1932 정수 삼각형 DP
	static int N, ans;
	static int[][] map;
	static Integer[][] dp; // 랩핑으로 선언하면 null객체로 관리할 수 있다.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		ans = 1 << 22;
		map = new int[N][N];
		dp = new Integer[N][N];
		for (int i = 0; i < N; i++) {
			int j = 0;
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				map[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) // 아래서부터 큰값을 위층으로 넣는 방법
			dp[N - 1][i] = map[N - 1][i];
		ans = recur(0, 0); // 최종적으로 맨 윗층 첫번째 칸에 최대값이 저장됨
//		print(dp);
		System.out.println(ans);
		br.close();
	}

	private static int recur(int n, int s) {
		if (n == N - 1) return dp[n][s];
//		print(dp);
		return dp[n][s] = (dp[n][s] == null) ? M(recur(n + 1, s), recur(n + 1, s + 1)) + map[n][s] : dp[n][s];
	}

	private static int M(int a, int b) {
		return Math.max(a, b);
	}

	private static void print(Integer[][] a) {
		StringBuilder tt = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if(a[i][j]==null)
					tt.append("n").append("\t");
				else
					tt.append(a[i][j]).append("\t");
			}
			tt.append("\n");
		}
		System.out.println(tt);
	}
}
