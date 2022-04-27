package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	static int W, H;
	static int[][] cheese;
	static int ans, cnt;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int cheeseCnt;

	static class Dot {
		int r, c;

		public Dot(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		cheese = new int[H][W];
		visited = new boolean[H][W];

		for (int i = 0; i < H; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; ++j) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if (cheese[i][j] == 1) {
					cnt++;
				}
			}
		}
		while (cnt > 0) {
			cheeseCnt = cnt;
			visited = new boolean[H][W];
			eatCheese();
			ans++;
		}
		// 치즈가 모두 녹아서 없어지는 데 걸리는 시간
		// 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸
		System.out.println(ans);
		System.out.println(cheeseCnt);

	}

	private static void eatCheese() {
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot(0, 0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Dot now = q.remove();
			for(int i = 0; i < 4; ++i) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				if(nr < 0 || nc < 0 || nr >= H || nc >= W) {
					continue;
				}
				if(!visited[nr][nc]) {
					visited[nr][nc] = true;
					if(cheese[nr][nc] == 0) {
						q.add(new Dot(nr, nc));
					}else {
						cnt--;
						cheese[nr][nc] = 0;
					}
				}
			}
		}
	}// eatCheese
}
