package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0630_JO_1707 {
	static int n, arr[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		arr = new int[n][n];

		int num = 1;
		int r = 0;
		int c = 0;
		int dir = 0;

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		
		while(true) {
			arr[r][c] = num;
			
			int nextR = r + dr[dir];
			int nextC = c + dc[dir];
			
			if (changeDir(nextR, nextC)) {
				// 방향 바꾸자
				dir = (dir + 1) % 4;
				nextR = r + dr[dir];
				nextC = c + dc[dir];
				
				if(changeDir(nextR, nextC)) {
					break;
				}
			}
			
			r = nextR;
			c = nextC;
			
			num++;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static boolean changeDir(int x, int y) {
		if (x < 0 || y < 0 || x >= n || y >= n || arr[x][y] != 0) {
			return true;
		}
		return false;
	}
}
