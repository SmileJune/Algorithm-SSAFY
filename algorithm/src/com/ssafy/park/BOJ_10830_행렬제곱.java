package com.ssafy.park;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10830_행렬제곱 {
	static int N;
	static long B;
	static int[][] arr;
	static final int M = 1000;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) % M;
			}
		}

		int[][] res = solve(B);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(res[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	public static int[][] solve(long cnt) {

		if (cnt == 1) {
			return arr;
		}

		int[][] res = solve(cnt / 2);

		if (cnt % 2 == 0) { 
			return cal(res, res);
		}

		else {  
			int[][] res2 = cal(res, arr);
			return cal(res, res2);
		}

	}

	public static int[][] cal(int[][] A, int[][] B) {
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					tmp[i][j] += (A[i][k] * B[k][j]) % M;
				}
				tmp[i][j] %= M;
			}
		}
		return tmp;
	}
}