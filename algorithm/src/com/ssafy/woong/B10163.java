package com.ssafy.woong;

import java.util.Scanner;

public class B10163 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] cnt = new int[n + 1];
		int[][] map = new int[1001][1001];
		for(int tc = 1; tc <= n; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();
			
			for(int i = y; i <= height + y - 1 ; i++) {
				for(int j = x; j <= width + x - 1; j++) {
					map[i][j] = tc;
				}
			}
			
		}
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				cnt[map[i][j]] += 1;
			}
		}
		
		for(int i = 1; i < cnt.length; i++) {
			System.out.println(cnt[i]);
		}
		
		
	}

}
