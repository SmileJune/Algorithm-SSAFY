package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_5650_핀볼게임 {
	static int N, max;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static List<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] >= 6) {
						list.add(new int[] { map[i][j], i, j });
					}
				}
			}
			max = 0;
			for (int i = 0; i < N * N; i++) {
				if (map[i / N][i % N] != 0)
					continue;
				game(i / N, i % N);
			}

			sb.append("#" + tc + " " + max + "\n");
		}
		System.out.println(sb);
	}

	private static void game(int r, int c) {

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			int dir = i; // 위 0 오 1 아 2 왼 3
			int cnt = 0;
			while (true) {
				if (nr < 0) {
					dir = 2;
					cnt++;
				} else if (nr == N) {
					dir = 0;
					cnt++;
				} else if (nc < 0) {
					dir = 1;
					cnt++;
				} else if (nc == N) {
					dir = 3;
					cnt++;
				} else {
					// 1
					if (map[nr][nc] == 1) {
						switch (dir) {
						case 1:
							dir = 3;
							cnt++;
							break;
						case 0:
							dir = 2;
							cnt++;
							break;
						case 2:
							dir = 1;
							cnt++;
							break;
						case 3:
							dir = 0;
							cnt++;
							break;
						}
					}
					// 2
					if (map[nr][nc] == 2) {
						switch (dir) {
						case 1:
							dir = 3;
							cnt++;
							break;
						case 0:
							dir = 1;
							cnt++;
							break;
						case 2:
							dir = 0;
							cnt++;
							break;
						case 3:
							dir = 2;
							cnt++;
							break;
						}
					}
					// 3
					if (map[nr][nc] == 3) {
						switch (dir) {
						case 1:
							dir = 2;
							cnt++;
							break;
						case 0:
							dir = 3;
							cnt++;
							break;
						case 2:
							dir = 0;
							cnt++;
							break;
						case 3:
							dir = 1;
							cnt++;
							break;
						}
					}
					// 4
					if (map[nr][nc] == 4) {
						switch (dir) {
						case 1:
							dir = 0;
							cnt++;
							break;
						case 0:
							dir = 2;
							cnt++;
							break;
						case 2:
							dir = 3;
							cnt++;
							break;
						case 3:
							dir = 1;
							cnt++;
							break;
						}
					}
					if (map[nr][nc] == 5) {
						switch (dir) {
						case 1:
							dir = 3;
							cnt++;
							break;
						case 0:
							dir = 2;
							cnt++;
							break;
						case 2:
							dir = 0;
							cnt++;
							break;
						case 3:
							dir = 1;
							cnt++;
							break;
						}
					}
					if (map[nr][nc] >= 6) {
						int a = map[nr][nc];
						for (int j = 0; j < list.size(); j++) {
							if (list.get(j)[0] == a && (list.get(j)[1] != nr || list.get(j)[2] != nc)) {
								nr = list.get(j)[1];
								nc = list.get(j)[2];
								break;
							}
						}
					}
					if (map[nr][nc] == -1) {
						max = Math.max(max, cnt);
						break;
					}
					if (nr == r && nc == c) {
						max = Math.max(max, cnt);
						break;
					}
				}
				switch (dir) {
				case 0:
					nr += dr[0];
					break;
				case 1:
					nc += dc[1];
					break;
				case 2:
					nr += dr[2];
					break;
				case 3:
					nc += dc[3];
					break;
				}
			}
		}
	}
}
