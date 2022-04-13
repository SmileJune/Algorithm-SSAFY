package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day65BOJ17435합성합수SparseTable연습 { // 17435 합성합수, sparse table 공부
	static final int log = 19; // 주어진 N의 최대값은 500_000, 2진 bit로 19레벨로 정한다.
	static int N, Q, x;
	static int[][] dp; // 주어진 함수를 그대로 반복하면, 시간초과 테이블을 미리 작성하여 활용한다.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		dp = new int[log + 1][N + 1]; // N의 번호는 1부터

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++)
			dp[0][i] = Integer.parseInt(st.nextToken());
		// 입력받은 값은 0번 자리에 행에 입력을 받는다.

		for (int i = 1; i < log + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				dp[i][j] = dp[i - 1][dp[i - 1][j]];
			} // 1행 이후의 행들의 값을 미리 작성한다.
		}

		Q = Integer.parseInt(br.readLine());
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			for (int i = 0; i < log; i++) {
				if ((n & 1 << i) > 0) { // n을 비트 읽어 값에 대입
					x = dp[i][x];
				} // sparse table 처리된 값을 호출한다.
			}
			sb.append(x).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
