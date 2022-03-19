package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2563_색종이{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] map = new boolean[101][101];
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 0; t < T; ++t) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int bottom = Integer.parseInt(st.nextToken());
			for( int r = 0; r < 10; ++r) {
				for(int c = 0; c < 10; ++c) {
					map[r+bottom][c+left] = true;
				}
			}
		}
		int cnt = 0;
		for(int i = 0; i < 100; ++i) {
			for(int j = 0; j < 100; ++j) {
				if(map[i][j]) 
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}