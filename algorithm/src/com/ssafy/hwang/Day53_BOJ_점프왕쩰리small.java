package com.ssafy.hwang;

import java.util.Scanner;

public class Day53_BOJ_점프왕쩰리small {
	static String res;
	static int[][] map;
	static int N;
	static boolean[][] marked;
				//	  우,하
	static int[] dr = {0,1};
	static int[] dc = {1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		res = "Hing";
		N = sc.nextInt();
		
		map = new int[N][N];
		marked = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}//입력 끝
		
		dfs(0,0);
		System.out.println(res);
	}
	static void dfs(int r, int c) {
		if(marked[r][c]) {
			return;
		}
		if(map[r][c]==-1) {
			res = "HaruHaru";
			return;
		}
		marked[r][c] = true;
		for(int i =0; i<2;i++) {
			int nr = r+dr[i]*map[r][c];
			int nc = c+dc[i]*map[r][c];
			if(0<=nr && nr<N && 0<=nc && nc<N ) {
				if(marked[nr][nc]) continue;
				dfs(nr,nc);
			}
		}
		
		
		
	}
}
