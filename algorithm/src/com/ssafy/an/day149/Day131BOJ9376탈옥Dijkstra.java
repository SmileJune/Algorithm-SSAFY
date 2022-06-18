package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Day131BOJ9376탈옥Dijkstra {

	private static int H, W;
	private static char[][] map;
	private static int[][][] counts;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H + 2][W + 2];
			counts = new int[H + 2][W + 2][3];

			Deque<int[]> dq = new LinkedList<>();
			int idx = 0;

			for (int i = 1; i <= H; i++) {
				String str = br.readLine();

				for (int j = 1; j <= W; j++) {
					map[i][j] = str.charAt(j - 1);

					if (map[i][j] == '$') {
						dq.add(new int[] { i, j, 1, idx });
						counts[i][j][idx++] = 1;
					}
				}
			}
			dq.add(new int[] { 0, 0, 1, idx });
			counts[0][0][idx] = 1;

			bw.write(solve(dq) + "\n");
		}
		bw.close();
	}

	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

	private static int solve(Deque<int[]> dq) {
		int min = Integer.MAX_VALUE;

		while (!dq.isEmpty()) {
			int[] node = dq.pollFirst();

			int r = node[0];
			int c = node[1];
			int count = node[2];
			int idx = node[3];

			if (counts[r][c][0] != 0 && counts[r][c][1] != 0 && counts[r][c][2] != 0) {
				int sum = counts[r][c][0] + counts[r][c][1] + counts[r][c][2] - 3;

				if (map[r][c] == '#') {
					min = Math.min(min, sum - 2);
				} else {
					min = Math.min(min, sum);
				}
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (index(nc, nr) && map[nr][nc] != '*' && counts[nr][nc][idx] == 0) {
					if (map[nr][nc] == '#') {
						dq.addLast(new int[] { nr, nc, count + 1, idx });
						counts[nr][nc][idx] = count + 1;
					} else {
						dq.addFirst(new int[] { nr, nc, count, idx });
						counts[nr][nc][idx] = count;
					}
				}
			}
		}
		return min;
	}

	private static boolean index(int x, int y) {
		return !(x < 0 || x > W + 1 || y < 0 || y > H + 1);
	}
}
