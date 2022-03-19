package com.ssafy.BOJ_GD;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int r;
	int c;
	int crush;
	int cnt;

	public Node(int r, int c, int crush, int cnt) {
		super();
		this.r = r;
		this.c = c;
		this.crush = crush;
		this.cnt = cnt;
	}
}

public class BOJ_2206_벽부수고이동하기 {
	static int[][] map;
	static int N, M;
	static boolean[][] crushO;
	static boolean[][] crushX;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		crushO = new boolean[N + 1][M + 1];
		crushX = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; ++i) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j - 1) -'0';
			}
		}
		bfs();
	}

	static void bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(1, 1, 1, 1));
		crushX[1][1] = true;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.r == N && node.c == M) {
				System.out.println(node.cnt);
				return;
			}
			for (int i = 0; i < 4; ++i) {
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];
				if (nr <= N && nr >= 1 && nc <= M && nc >= 1) {
					if (map[nr][nc] == 1) {
						if (node.crush == 1 && !crushX[nr][nc]) {
							crushX[nr][nc] = true;
							crushO[nr][nc] = true;
							q.add(new Node(nr, nc, 0, node.cnt + 1));
						}
					} else { // map[nr][nc] == 0 이면.
						if (node.crush == 0 && !crushO[nr][nc]) {
							q.add(new Node(nr, nc, 0, node.cnt + 1));
							crushO[nr][nc] = true;
						}
						if (node.crush == 1 && !crushX[nr][nc]) {
							q.add(new Node(nr, nc, 1, node.cnt + 1));
							crushX[nr][nc] = true;
						}
					}
				}
			}
		}
		
		System.out.println(-1);
	}
}