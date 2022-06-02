package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day28BOJ1012유기농배추 { // 1012 유기농배추
	static int M, N, K;
	static int[][] arr;
	static boolean[][] visit;
	static int cnt;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			arr = new int[M][N];
			visit = new boolean[M][N];

			K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				arr[p1][p2] = 1;
			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1 && !visit[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}

	static void dfs(int i, int j) {
		visit[i][j] = true;
		
		for (int idx = 0; idx < 4; idx++) {
			int cx = i + dx[idx];
			int cy = j + dy[idx];
			if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
				if (!visit[cx][cy] && arr[cx][cy] == 1) {
					dfs(cx, cy);
				}
			}
		}
	}
}
