package com.ssafy.woong;

import java.util.Scanner;

public class B2567 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int cnt = 0;
		int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
		int[][] map = new int[101][101];
		for(int idx = 0; idx < n; idx++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int i = y ; i < y+10; i++) {
				for(int j = x ; j < x+10; j++) {
					map[i][j] = 1;
				}
			}
			
		}
		
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <=100; j++) {
				if(map[i][j] == 1) {
					for(int k = 0; k < 4; k++) {
						if(map[i+d[k][0]][j+d[k][1]] == 0) {
							cnt++;
						}
					}
				}
			} 
		}
		System.out.println(cnt);
		
		
	}

}
