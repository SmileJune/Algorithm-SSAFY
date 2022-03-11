package com.ssafy.namja;

import java.util.Scanner;
public class BOJ_7236_박성현 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			int[] search_x = {0,0,-1,1,-1,-1,1,1};	// 상 하 좌 우 좌상 좌하 우상 우하
			int[] search_y = {-1,1,0,0,-1,1,-1,1};	// 상 하 좌 우 좌상 좌하 우상 우하
			for (int t = 1; t <= T; t++) {
				int N = sc.nextInt();
				String[][] area = new String[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++)
						area[i][j] = sc.next();
				}
				
				int max = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						int sum = 0;
						for (int idx = 0; idx < 8; idx++) {
							if (i+search_y[idx] < 0 || i+search_y[idx] == N
									|| j+search_x[idx] < 0 || j+search_x[idx] == N)
								continue;
							else if(area[i+search_y[idx]][j+search_x[idx]].equals("W"))
								sum++;
						}
						max = Math.max(max, sum);
					}
				}
				System.out.printf("#%d %d\n",t,max);
			}
		}
	}
