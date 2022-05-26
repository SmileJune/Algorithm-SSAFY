package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day109BOJ10830행렬제곱 { // 10830 행렬제곱, 이전에 행렬 곱 문제를 실패했던적 있는데, 이번에도 실패하여 구선생님 도움으로..
	static final int MOD = 1000;
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken()); // 타입 주의

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken()) % MOD;
		}

		int[][] res = pow(arr, B);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sb.append(res[i][j]).append(' ');
			sb.append('\n');
		}
		System.out.println(sb);
		br.close();
	}

	public static int[][] pow(int[][] A, long exp) {
		if (exp == 1L)
			return A;

		int[][] ret = pow(A, exp / 2);

		ret = multiply(ret, ret);

		if (exp % 2 == 1L)
			ret = multiply(ret, arr);

		return ret;
	}

	public static int[][] multiply(int[][] o1, int[][] o2) {
		int[][] ret = new int[N][N];

		int r;
		for (int k = 0; k < N; k++)
			for (int i = 0; i < N; i++) {
				r = o1[i][k];
				for (int j = 0; j < N; j++) {
					ret[i][j] += r * o2[k][j];
					ret[i][j] %= MOD;
				}
			}

		return ret;
	}
}
