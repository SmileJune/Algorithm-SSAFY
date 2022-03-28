package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day49BOJ7562나이트이동BFS구현연습 { // 7562 나이트 이동
	static int N;
	static boolean[][] visited;
	static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dc = { -2, -1, 1, 2, -2, -1, 1, 2 };
	static Point st, ed;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stn = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N][N];
			stn = new StringTokenizer(br.readLine());
			st = new Point(Integer.parseInt(stn.nextToken()), Integer.parseInt(stn.nextToken()), 0);
			stn = new StringTokenizer(br.readLine());
			ed = new Point(Integer.parseInt(stn.nextToken()), Integer.parseInt(stn.nextToken()), 0);
			sb.append(bfs()).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(st);
		visited[st.r][st.c] = true;
		while (!q.isEmpty()) {
			Point n = q.poll();
			if (n.r == ed.r && n.c == ed.c)
				return n.d;
			for (int d = 0; d < 8; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (visited[nr][nc])
					continue;
				visited[nr][nc] = true;
				q.add(new Point(nr, nc, n.d + 1));
			}
		}
		return 0;
	}

	static class Point {
		int r, c, d = 0;

		public Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
}
