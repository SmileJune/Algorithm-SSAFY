package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day79BOJ7569토마토BFS3차원델타 {
	static class Tmt {
		int h, r, c;
		int time;

		Tmt(int h, int r, int c, int time) {
			this.h = h;
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

	static int M, N, H; // 가로(c), 세로(r), 높이(h)
	static int ans, tot;
	static int[] dh = { -1, 1, 0, 0, 0, 0 }, dr = { 0, 0, -1, 1, 0, 0 }, dc = { 0, 0, 0, 0, -1, 1 };
	static int[][][] boxes; // H, N, M : 층 > 행 > 열
	static Queue<Tmt> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		ans = -1; // 시간 초기화
		tot = H * M * N;
		boxes = new int[H][N][M]; // 입력 서순 -> 반복문 순서
		q = new LinkedList<>();
		// 예제 1
		// 5 3 1 -- 열, 행, 높이
		// 0 -1 0 0 0
		// -1 -1 0 1 1
		// 0 0 0 1 1
		for (int h = 0; h < H; h++) { // 서순 주의
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					boxes[h][n][m] = Integer.parseInt(st.nextToken());
					if (boxes[h][n][m] == 1)
						q.add(new Tmt(h, n, m, 0));
					else if (boxes[h][n][m] == -1)
						tot--;
				}
			}
		}

		while (!q.isEmpty()) {
			Tmt t = q.poll();
			tot--;
			ans = t.time;
			for (int dir = 0; dir < 6; dir++) {
				int nh = t.h + dh[dir];
				int nr = t.r + dr[dir];
				int nc = t.c + dc[dir];
				if (index(nh, nr, nc))
					continue;
				if (boxes[nh][nr][nc] != 0)
					continue;
				boxes[nh][nr][nc] = 1;
				q.add(new Tmt(nh, nr, nc, t.time + 1));
			}
		}

		System.out.println(tot > 0 ? -1 : ans);
		br.close();
	}

	private static boolean index(int h, int r, int c) {
		return h < 0 || r < 0 || c < 0 || h >= H || r >= N || c >= M;
	}

}
