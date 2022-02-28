package com.ssafy.namja;

import java.util.Scanner;
public class BOJ_2567_박성현 {
	static int max_x, max_y, min_x, min_y;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		int[][] area = new int[102][102];
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		for (int n = 0; n < num; n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
					
			for (int i = x; i < x + 10; i++)
				for (int j = y; j < y + 10; j++)
					area[i][j] = 1;
		}

		int sum = 0;
		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				if (area[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int dx = i + dr[d];
						int dy = j + dc[d];
						if (area[dx][dy] == 0 && dx >= 0 && dy >= 0 && dx < 102 && dy < 102)
							sum++;
					}
				}
			}
		}
		
		System.out.println(sum);
	}	
}
