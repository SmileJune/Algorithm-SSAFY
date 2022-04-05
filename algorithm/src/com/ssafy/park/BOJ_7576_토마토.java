package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	public static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int M, N;
	static int[][] map;
	static Queue<Point> queue = new LinkedList<>();
	static boolean[][] visited;
	static int cnt = 0;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					queue.add(new Point(i, j));
					visited[i][j] = true;
					cnt++;
				}
				if (map[i][j] == -1) {
					visited[i][j] = true;
					cnt++;
				}
			}
		}
		int ans = 0;
		while (cnt < N * M) {
			ans++;
			int num = queue.size();
			for (int i = 0; i < num; i++) {
				bfs(queue.poll());
			}
			if (queue.isEmpty()) {
				ans = -1;
				break;
			}
		}
		System.out.println(ans);
	}

	public static void bfs(Point start) {
		int r;
		int c;
		for (int i = 0; i < 4; i++) {
			r = start.r + dr[i];
			c = start.c + dc[i];
			if (r < 0 || r >= N || c < 0 || c >= M) {
				continue;
			}
			if (!visited[r][c]) {
				visited[r][c] = true;
				queue.add(new Point(r, c));
				cnt++;
			}
		}
	}
}
