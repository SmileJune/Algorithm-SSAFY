package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_2563_박성현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int[][] papers = new int[num][2];

		int max_x = 0, max_y = 0;
		int min_x = Integer.MAX_VALUE, min_y = Integer.MAX_VALUE;
		for (int i = 0; i < num; i++) {
			papers[i][0] = sc.nextInt(); // x 좌표
			papers[i][1] = sc.nextInt(); // y 좌표
			max_x = Math.max(max_x, papers[i][0]);
			max_y = Math.max(max_y, papers[i][1]);
			min_x = Math.min(min_x, papers[i][0]);
			min_y = Math.min(min_y, papers[i][1]);
		}

		int[][] area = new int[max_x + 10][max_y + 10];

		for (int idx = 0; idx < num; idx++) {
			for (int i = 0; i <= max_x; i++) {
				for (int j = 0; j <= max_y; j++) {
					if (i == papers[idx][0] && j == papers[idx][1]) {
						for (int a = 0; a < 10; a++)
							for (int b = 0; b < 10; b++)
								area[i + a][j + b] = 1;
					}
				}
			}
		}

		int sum = 0;
		for (int i = min_x; i < max_x + 10; i++)
			for (int j = min_y; j < max_y + 10; j++)
				sum += area[i][j];
		System.out.println(sum);
	}
}
