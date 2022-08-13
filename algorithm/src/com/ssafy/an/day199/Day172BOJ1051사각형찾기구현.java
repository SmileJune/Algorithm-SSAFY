package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day172BOJ1051사각형찾기구현 { // 1051
	static int N, M, ans, min;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N
		M = Integer.parseInt(st.nextToken()); // M
		ans = 0;
		min = Math.min(N, M);
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String l = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = l.charAt(j);
			}
		}

		int m = 0;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				for (int i = 0; i < min; i++) {
					int nx = x + i;
					int ny = y + i;
					if (nx < N && ny < M) {
						if (map[x][y] == map[x][ny] && map[x][y] == map[nx][y] && map[x][y] == map[nx][ny]) {
							m = (i + 1) * (i + 1);
							ans = Math.max(ans, m);
						}
					}
				}
			}
		}
		System.out.println(ans);
		br.readLine();
	}
}
