package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class XY {
	int r;
	int c;

	public XY(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class BOJ_2583_영역구하기 {
	static boolean[][] map;
	static int M, N, K;
	static Queue<XY> q = new LinkedList<>();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] cnt;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[M][N];
		cnt = new int[M * N];

		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			int sX = Integer.parseInt(st.nextToken());
			int sY = Integer.parseInt(st.nextToken());
			int eX = Integer.parseInt(st.nextToken());
			int eY = Integer.parseInt(st.nextToken());
			for (int y = sY; y < eY; ++y) {
				for (int x = sX; x < eX; ++x) {
					map[y][x] = true;
				}
			}

		}

		for (int i = 0; i < M; ++i) {
			for (int j = 0; j < N; ++j) {
				if (!map[i][j]) {
					map[i][j] = true;
					q.add(new XY(i, j));
					ans++;
					cnt[ans] = 1;
					BFS();
				}
			}
		}
		Arrays.sort(cnt);
		System.out.println(ans);
		for (int i = 0; i < cnt.length; ++i) {
			if (cnt[i] != 0) {
				System.out.print(cnt[i] + " ");
			}
		}
	}

	static void BFS() {
		while (!q.isEmpty()) {
			XY d = q.poll();
			for (int i = 0; i < 4; ++i) {
				int nr = d.r + dr[i];
				int nc = d.c + dc[i];
				if (nr >= 0 && nc >= 0 && nr < M && nc < N) {
					if (!map[nr][nc]) {
						map[nr][nc] = true;
						cnt[ans]++;
						q.add(new XY(nr, nc));
					}
				}
			}
		}
	}
}
