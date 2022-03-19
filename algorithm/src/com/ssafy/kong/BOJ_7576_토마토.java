package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	static int N, M;
	static int[][] box;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<rc> tomato = new LinkedList<>();
	static int cnt = 0;
	static int ans = 0;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					tomato.add(new rc(i, j));
				}
				if(box[i][j] == 0) {
					cnt++;
				}
			}
		}
		BFS();
		if(cnt==0) {
			System.out.println(ans);
		} else
			System.out.println(-1);
	}

	static public void BFS() {
		while (!tomato.isEmpty()) {
			rc dot = tomato.poll();
			visited[dot.r][dot.c] = true;
			for (int i = 0; i < 4; ++i) {
				int nr = dot.r + dr[i];
				int nc = dot.c + dc[i];
				if (nr >= 0 && nr < N && nc < M && nc >= 0) {
					if (!visited[nr][nc] && box[nr][nc] == 0) {
						box[nr][nc] = box[dot.r][dot.c] + 1;
						visited[nr][nc] = true;
						tomato.add(new rc(nr, nc));
						cnt--;
						if(cnt == 0) {
							flag = true;
							ans = box[dot.r][dot.c];
						}
					}
				}
			}
		}
	}
}
class rc {
	int r;
	int c;

	public rc(int r, int c) {
		this.r = r;
		this.c = c;
	}
}