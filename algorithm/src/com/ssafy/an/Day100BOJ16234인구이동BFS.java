package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day100BOJ16234인구이동BFS { // 16234 인구이동
	static int N, L, R, ans;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] visit;
	static Queue<Pos> q;
	static List<Pos> uni;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {
			if (bfs() == 0)
				break;
			else
				ans++;
		}
		System.out.println(ans);
		br.close();
	}

	private static int bfs() {
		int rst = 0;
		visit = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (visit[r][c])
					continue;
				Pos pos = new Pos(r, c);
				q = new LinkedList<>();
				uni = new LinkedList<>();
				q.add(pos);
				uni.add(pos);
				visit[r][c] = true;
				int sum = map[r][c];
				while (!q.isEmpty()) {
					Pos p = q.poll();
					for (int i = 0; i < 4; i++) {
						int nr = p.r + dr[i];
						int nc = p.c + dc[i];
						if (index(nr, nc) || visit[nr][nc] || check(map[p.r][p.c], map[nr][nc]))
							continue;
						Pos np = new Pos(nr, nc);
						q.add(np);
						uni.add(np);
						visit[nr][nc] = true;
						sum += map[nr][nc];
						rst++;
					}
				}
				if (rst > 0) {
					for (int i = 0; i < uni.size(); i++) {
						Pos p = uni.get(i);
						map[p.r][p.c] = sum / uni.size();
					}
				}
			}
		}
		return rst;
	}

	private static boolean check(int a, int b) {
		return Math.abs(a - b) < L || Math.abs(a - b) > R;
	}

	private static boolean index(int r, int c) {
		return r < 0 || c < 0 || r >= N || c >= N;
	}

	static class Pos {
		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
