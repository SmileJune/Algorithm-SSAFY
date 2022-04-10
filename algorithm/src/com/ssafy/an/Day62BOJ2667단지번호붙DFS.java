package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Day62BOJ2667단지번호붙DFS {
	static int N, cnt;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static int[][] map;
	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		cnt = 0;
		map = new int[N][N];
		pq = new PriorityQueue<>(); // 오름차순 출력을 위한 최소힙

		for (int i = 0; i < N; i++) {
			String st = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = st.charAt(j) - 49; // 0 -> -1, 1 -> 0
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					tmp = 0;
					dfs(i, j, 0, ++cnt); // 좌표, 갯수, 붙힐번호=단지수
					pq.offer(tmp);
//					print(map); // 출력확인
				}
			}
		}
		sb.append(cnt).append("\n");
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static int tmp = 0;

	private static void dfs(int idx, int jdx, int t, int c) {
		if (map[idx][jdx] == -1)
			return;

		tmp++;
		map[idx][jdx] = c;

		for (int dir = 0; dir < 4; dir++) {
			int nr = idx + dr[dir];
			int nc = jdx + dc[dir];
			if (!check(nr, nc) && map[nr][nc] == 0)
				dfs(nr, nc, t + 1, c);
		}

	}

	private static boolean check(int idx, int jdx) {
		return idx < 0 || idx >= N || jdx < 0 || jdx >= N;
	}

	private static void print(int[][] a) {
		StringBuilder tt = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tt.append(map[i][j]).append("\t");
			}
			tt.append("\n");
		}
		System.out.println(tt);
	}

}
