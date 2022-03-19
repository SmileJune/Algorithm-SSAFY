package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16927_배열돌리기 {
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
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < min; ++j) {
				int x = j;
				int y = j;
				int tmp = arr[x][y];

				int dir = 0;
				while (dir < 4) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					if (nx >= j && ny >= j && nx < N - j && ny < M - j) {
						arr[x][y] = arr[nx][ny];
						x = nx;
						y = ny;
					}
					else
						dir++;
				}
				arr[j+1][j] = tmp;
			}
		}
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}