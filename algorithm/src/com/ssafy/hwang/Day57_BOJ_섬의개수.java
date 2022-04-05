package com.ssafy.hwang;

import java.util.Scanner;

/**
 * @author kwan 팔방탐색문제 팔방에 붙어있으면 방문처리하자.
 */
public class Day57_BOJ_섬의개수 {
	static int[][] map;
	static boolean[][] marked;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int W, H, cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			cnt=0;
			
			W = sc.nextInt(); // 너비
			H = sc.nextInt(); // 높이
			if (W == 0 && H == 0)
				return; // 0,0 들어오면 종료
			map = new int[H][W];
			marked = new boolean[H][W];

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			} // 입력 종료

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] != 0 && !marked[i][j]) {
						dfs(i, j);
						cnt ++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void dfs(int r, int c) {
		marked[r][c] = true;
		
		for(int i=0;i<8;i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if( isNotRange(nr,nc) ) continue;
			if( marked[nr][nc] || map[nr][nc]==0) continue;
			marked[nr][nc] = true;
			dfs(nr,nc);
		}

	}

	private static boolean isNotRange(int r, int c) {
		if( r<0 || c<0 || r>=H || c>=W ) return true;
		return false;
	}
}
