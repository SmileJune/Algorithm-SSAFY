package com.ssafy.hwang;

import java.util.Scanner;

public class Day61_BOJ_그림 {
	static int map[][], MaxArea, cntPicture, tmpArea, N, M;
	static boolean marked[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		marked = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		} // 입력 처리 끝

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) continue;
				if(marked[i][j]) continue;
				cntPicture++;
				tmpArea =0 ;
				dfs(i,j);
				MaxArea = Math.max(MaxArea, tmpArea);
			}
		}
		System.out.println(cntPicture+"\n"+MaxArea);
	}

	private static void dfs(int r, int c) {
		tmpArea++;
		marked[r][c] = true;
		for(int i =0 ; i<4;i++) {
			int nr = r+dr[i];
			int nc = c + dc[i];
			if(inNotRange(nr,nc)) continue;
			if(marked[nr][nc]) continue;
			if(map[nr][nc]==0) continue;
			
			dfs(nr,nc);
		}
		
	}

	private static boolean inNotRange(int r, int c) {
		if(r<0 || c<0 || r>=N || c>=M) return true;
		return false;
	}
}
