package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {
	static int N, L, R;
	static int[][] A;
	static int ans, sum, cnt;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static boolean[][] visited;
	static boolean[][] check;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		visited = new boolean[N][N];
		check = new boolean[N][N];

		int idx = 0;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {
			flag = false;
			visited = new boolean[N][N];
			check = new boolean[N][N];
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (!visited[i][j]) {
						sum = A[i][j];
						cnt = 1;
						visited[i][j] = true;
						openLine(i, j);
						if (cnt > 1) {
							move();
						} else if (cnt == 1) {
							check[i][j] = true;
						}
					}
				}
			}
			if (!flag) {
				break;
			}
			ans++;
		}
		System.out.println(ans);
	}

	private static void move() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (!check[i][j] && visited[i][j]) {
					A[i][j] = sum / cnt;
					check[i][j] = true;
				}
			}
		}

//		for (int i = 0; i < N; ++i) {
//			System.out.println(Arrays.toString(tmp[i]));
//		}
	}

	private static void openLine(int r, int c) {
		for (int k = 0; k < 4; ++k) {
			int nr = dr[k] + r;
			int nc = dc[k] + c;
			if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
				continue;
			}
			int val = Math.abs(A[nr][nc] - A[r][c]);
			if (!visited[nr][nc] && val >= L && val <= R) {
				sum += A[nr][nc];
				cnt++;
				flag = true;
				visited[nr][nc] = true;
				openLine(nr, nc);
			}
		}
	}

}
