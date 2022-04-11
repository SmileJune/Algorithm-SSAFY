package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Day63BOJ2178미로탐색BFS {
	static class Pos {
		int r, c, d;

		public Pos(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	static int N, M, cnt = 1;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);		

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = in.charAt(j) - '0';
			}
		}

		bfs();

		System.out.println(cnt);
		br.close();
	}

	private static void bfs() {
		Queue<Pos> q = new LinkedList<>();

		q.add(new Pos(0, 0, 1));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Pos p = q.poll();
			if (p.r == N - 1 && p.c == M - 1) {
				cnt = p.d;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (index(nr, nc))
					continue;
				if (!visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.offer(new Pos(nr, nc, p.d + 1));					
				}
			}
		}
	}

	private static boolean index(int nr, int nc) {
		return nr < 0 || nr >= N || nc < 0 || nc >= M;
	}

}
