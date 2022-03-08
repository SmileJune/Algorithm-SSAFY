package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day29BOJ1018체스판다시칠하기브루트포스 { // 1018 체스판 다시 칠하기
	static int[][] chess;
	static int min = 111;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		chess = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				chess[i][j] = str.charAt(j) == 'B' ? 1 : 0;
			}
		}

		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				check(i, j);
			}
		}

		System.out.println(min);
		br.close();
	}

	private static void check(int idx, int jdx) {
		int cnt = 0;

		int first = chess[idx][jdx];

		for (int i = idx; i < idx + 8; i++) {
			for (int j = jdx; j < jdx + 8; j++) {
				if (chess[i][j] != first) {
					cnt++;
				}
				first = (first + 1) % 2;
			}
			first = (first + 1) % 2;
		}
		cnt = Math.min(cnt, 64 - cnt);
		min = Math.min(min, cnt);
	}
}
