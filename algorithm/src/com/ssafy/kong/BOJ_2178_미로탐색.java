package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dot {
	int r;
	int c;

	public Dot(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class BOJ_2178_미로탐색 {
	static boolean[][] visit;
	static int[][] map;
	static int N, M, ans;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<Dot> q = new LinkedList<Dot>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		visit = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; ++i) {
			String str = br.readLine();
			for (int j = 1; j <= M; ++j) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}
		BFS();
	}

	static void BFS() {
		q.add(new Dot(1, 1));
		visit[1][1] = true;
		while (!q.isEmpty()) {
			Dot dot = q.remove();
			for (int i = 0; i < 4; ++i) {
				int nr = dot.r + dr[i];
				int nc = dot.c + dc[i];
				if (nr > 0 && nc > 0 && nr <= N && nc <= M) {
					if(map[nr][nc]!= 0 && !visit[nr][nc]) {
						visit[nr][nc] = true;
						map[nr][nc] = map[dot.r][dot.c] + 1;
						q.add(new Dot(nr, nc));
					}
				}
			}
		}
		System.out.println(map[N][M]);
	}
}
