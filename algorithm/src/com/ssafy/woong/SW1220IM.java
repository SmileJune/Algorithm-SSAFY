package com.ssafy.woong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1220IM {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = 10;
		for(int i = 1; i <= T; i++) {
			System.out.printf("#%d %d\n",i,solution());
		}
	}
	
	static int solution() throws NumberFormatException, IOException {
		br.readLine();
		int[][] map = new int[100][100];
		for(int i = 0 ; i < 100 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 100 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int cnt = 0;
		for(int i = 0; i < 100 ; i ++) {
			boolean flag = false;
			for(int j = 0 ; j < 100; j++) {
				if(map[j][i] == 1) {
					flag = true;
				}
				if(map[j][i] == 2 && flag) {
					flag = false;
					cnt++;
				}
			}
		}
		return cnt;
		
	}
}