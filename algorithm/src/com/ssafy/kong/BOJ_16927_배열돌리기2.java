package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16927_배열돌리기2 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
//	static int[] dx = { 0, 1, 0, -1 };
//	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 행의 길이
		int M = Integer.parseInt(st.nextToken()); // 열의 길이
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int min = Math.min(N, M) / 2;
		for (int i = 0; i < min; ++i) {
			int nr = R % ((N - i * 2) * 2 + (M - i * 2) * 2 - 4);
			while (nr-- != 0) {
				int x = i;
				int y = i;
				int dir = 0;
				int tmp = arr[x][y];
				while (dir < 4) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					if (nx >= i && ny >= i && nx < N - i && ny < M - i) {
						arr[x][y] = arr[nx][ny];
						x = nx;
						y = ny;
					} else
						dir++;
				}
				arr[i + 1][i] = tmp;
			}
		}
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}