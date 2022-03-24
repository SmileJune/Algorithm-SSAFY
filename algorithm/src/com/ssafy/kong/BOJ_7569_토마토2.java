package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토2 {
	static int N, M, H;
	static int[][] box;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0, 0, 0 };
	static int[] dc = { 0, 1, 0, -1, 0, 0 };
	static Queue<Dot> tomato = new LinkedList<>();
	static int cnt = 0;
	static int ans = 0;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		dr[4] = N;
		dr[5] = -N;
		box = new int[N * H][M];
		visited = new boolean[N * H][M];
		for (int i = 0; i < N * H; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					tomato.add(new Dot(i, j));
				}
				if (box[i][j] == 0) {
					cnt++;
				}
			}
		}
		BFS();
		if (cnt == 0) {
			System.out.println(ans);
		} else
			System.out.println(-1);
	}

	static public void BFS() {
		while (!tomato.isEmpty()) {
			Dot dot = tomato.remove();
			visited[dot.r][dot.c] = true;
//			System.out.println("r는" + dot.r + "c는" + dot.c);
//			for (int r = 0; r < N * H; ++r) {
//				for (int c = 0; c < M; ++c) {
//					System.out.print(box[r][c] + " ");
//				}
//				System.out.println();
//			}
			System.out.println("예!");
			for (int i = 0; i < 6; ++i) {
				int nr = dot.r + dr[i];
				int nc = dot.c + dc[i];
				int m = 0;
				if (i < 4) {
					for (int k = 0; k < H; ++k) {
						if (N * k <= dot.r && dot.r < N * (k + 1)) {
							m = k;
							break;
						}
					}
				}else {
					for (int k = 0; k < H; ++k) {
						if (N * k <= nr && nr < N * (k + 1)) {
							m = k;
							break;
						}
					}
				}
				if (nr >= m * N && nr < N * (m + 1) && nc < M && nc >= 0) {
					if (!visited[nr][nc] && box[nr][nc] == 0) {
						box[nr][nc] = box[dot.r][dot.c] + 1;
						visited[nr][nc] = true;
						tomato.add(new Dot(nr, nc));
						cnt--;
						if (cnt == 0) {
							flag = true;
							ans = box[dot.r][dot.c];
						}
					}
				}
			}
		}
	}
}
