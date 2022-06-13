package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1890_점프 {
	static int N;
	static int[][] map;

	static class Dot {
		int r, c;

		public Dot(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { 1, 0 };
	static int[] dc = { 0, 1 };
	static long ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 이게임의 목표는 가장 왼쪽 위 칸에서 가장오른쪽 칸으로 규칙에 맞게 점프하는 것이다.
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		System.out.println(ans);
	}

	private static void bfs() {
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot(0, 0));
		// 0, 0 부터 시작하자.
		while (!q.isEmpty()) {
			Dot now = q.remove();
			int jump = map[now.r][now.c];
			if (now.r == N - 1 && now.c == N - 1) {
				ans++;
				// 만약 끝에 도달했으면 정답 카운트를 1 늘려주고
				continue;
			}
			if (map[now.r][now.c] == 0) {
				continue;
			}
			for (int i = 0; i < 2; ++i) {
				int nr = dr[i] * jump + now.r;
				int nc = dc[i] * jump + now.c;
				// 점프한것만큼 곱해줘야한다.
				if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
					continue;
				}
				q.add(new Dot(nr, nc));
				// 만약 범위에 없으면 그냥 넘겨버려라.
			}
		}
	}
}
