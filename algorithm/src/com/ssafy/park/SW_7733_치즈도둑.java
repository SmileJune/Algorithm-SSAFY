package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_7733_치즈도둑 {
	static int N;
	static int[][] map;
	static int[][] mapcopy;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int day = 1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			day = 1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 1;
			for (int n = 0; n < 100; n++) {				
				eat();
				mapcopy = new int[N][N];
				for (int i = 0; i < N; i++) {
					System.arraycopy(map[i], 0, mapcopy[i], 0, map[i].length);
				}
				int temp = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (count(i,j)) temp++;
					}
				}
				max = Math.max(max, temp);
				day++;
			}
			sb.append(max + "\n");
		}
		System.out.println(sb);
	}
	public static void eat() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == day) {
					map[i][j] = 0;
				}
			}
		}
	}
	public static boolean count(int r, int c) {
		if (c == -1 || r == -1 || c == N || r == N)
			return false;
		if (mapcopy[r][c] == 0)
			return false;
		mapcopy[r][c] = 0;
		for (int i = 0; i < dr.length; i++) {
			int drr = dr[i];
			int dcc = dc[i];
			count(r + drr, c + dcc);
		}
		return true;
	}
}
