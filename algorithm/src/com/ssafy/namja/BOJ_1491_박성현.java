package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_1491_박성현 {
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[][] visited = new boolean[M][N];
		cnt = N*M;
		int start_x = 0;
		int start_y = 0;
		while (true) {
			for (int x = start_x; x < N; x++) {
				if (visited[start_y][start_x])
					break;
				visited[start_y][start_x++] = true;
				cnt--;
			}
			start_x--;
			if (cnt == 0)
				break;
			start_y++;
			for (int y = start_y; y < M; y++) {
				if (visited[start_y][start_x])
					break;
				visited[start_y++][start_x] = true;
				cnt--;
			}
			start_y--;
			if (cnt == 0)
				break;
			start_x--;
			for (int x = start_x; x >= 0; x--) {
				if (visited[start_y][start_x])
					break;
				visited[start_y][start_x--] = true;
				cnt--;
			}
			start_x++;
			if (cnt == 0)
				break;
			start_y--;
			for (int y = start_y; y >= 0; y--) {
				if (visited[start_y][start_x])
					break;
				visited[start_y--][start_x] = true;
				cnt--;
			}
			start_y++;
			if (cnt == 0)
				break;
			start_x++;
		}
		System.out.print(start_x + " " + start_y);
	}
	
}