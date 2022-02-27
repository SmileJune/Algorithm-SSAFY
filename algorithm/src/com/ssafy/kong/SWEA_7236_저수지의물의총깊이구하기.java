package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7236_저수지의물의총깊이구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N + 2][N + 2];
			for (int i = 1; i <= N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; ++j) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
			int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
			int max = 1; // 둘러싼 모든 영역이 땅(G)인 경우  그 구획의 물 깊이는 1

			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					if (map[i][j] == 'W') {
						int cnt = 0;
						for (int k = 0; k < 8; k++) {
							if (map[i + dr[k]][j + dc[k]] == 'W') {
								cnt++;
							}
						}
						max = Math.max(max, cnt);
					}
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
}