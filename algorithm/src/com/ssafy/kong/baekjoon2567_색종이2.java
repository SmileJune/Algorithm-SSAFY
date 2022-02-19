package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2567_색종이2{
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] map1 = new boolean[102][102]; // 가로 데이터
		boolean[][] map2 = new boolean[102][102]; // 세로 데이터
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] dir = new int[T][2];
		for(int t = 0; t < T; ++t) {
			st = new StringTokenizer(br.readLine());
			dir[t][0] = Integer.parseInt(st.nextToken());	// 왼쪽에서부터 거리
			dir[t][1] = Integer.parseInt(st.nextToken());	// 아래로부터 거리
			for( int r = 0; r < 10; ++r) {
				for(int c = 0; c < 10; ++c) {
					map1[r+dir[t][1]][c+dir[t][0]] = map2[c+dir[t][0]][r+dir[t][1]] = true;
				}
			}
		}
		
		findLine(map1);
		findLine(map2);
		System.out.println(cnt);
	}
	static void findLine(boolean[][] map) {
		for(int c = 0; c <= 100; ++c) {
			for(int r = 0; r <= 100; ++r) {
				if( map[c][r] ) {
					cnt++;
					map[c][r] = false;
					while( r <= 100 ) {
						if( !map[c][r+1] ) {
							r--;
							break;
						}
						r++;
					}
				}
			}
		}
	}
}