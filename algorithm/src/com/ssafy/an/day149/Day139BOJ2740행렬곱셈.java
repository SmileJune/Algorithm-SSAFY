package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day139BOJ2740행렬곱셈 { // 2740 행렬 곱셈
	static int N, M, K;
	static int[][] A, B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				A[i][j] = Integer.parseInt(st.nextToken());

		}

		st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		B = new int[M][K];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++)
				B[i][j] = Integer.parseInt(st.nextToken());

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				int sum = 0;
				for (int k = 0; k < M; k++)
					sum += A[i][k] * B[k][j];
				sb.append(sum).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
		br.close();
	}
}
