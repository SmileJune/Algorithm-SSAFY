package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {
	static int N;
	static char[][] map;
	static char[][] mapBlind;
	static boolean[][] check;
	static boolean[][] checkBlind;

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int ans, ansBlind;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		mapBlind = new char[N][N];
		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			for (int j = 0; j < N; ++j) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R' || map[i][j] == 'G') {
					mapBlind[i][j] = 'R';
					continue;
				}
				mapBlind[i][j] = map[i][j];

			}
		}
		check = new boolean[N][N];
		checkBlind = new boolean[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (!check[i][j]) {
					BFS(check, map, map[i][j], i, j);
					ans++;
				}
				if (!checkBlind[i][j]) {
					BFS(checkBlind, mapBlind, mapBlind[i][j], i, j);
					ansBlind++;
				}
			}
		}
		System.out.println(ans + " " + ansBlind);

	}

	private static void BFS(boolean[][] check, char[][] map, char color, int r, int c) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		check[r][c] = true;
		while (!q.isEmpty()) {
			Node now = q.remove();
			for (int i = 0; i < 4; ++i) {
				int nr = dr[i] + now.r;
				int nc = dc[i] + now.c;
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (map[nr][nc] == color && !check[nr][nc]) {
					q.add(new Node(nr, nc));
					check[nr][nc] = true;
				}
			}
		}
	}
}
