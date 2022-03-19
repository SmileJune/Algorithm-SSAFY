package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_2578 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		boolean[][] visited = new boolean[5][5];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int cnt = 0;
		while (sc.hasNext()) {
			int input = sc.nextInt();
			cnt++;
			int bingo = 0;

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (arr[i][j] == input) {
						visited[i][j] = true;
					}
				}
			}

			// 가로
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (visited[i][j] == false) {
						break;
					}
					if (j == 4) {
						bingo++;
					}
				}
			}

			// 세로
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (visited[j][i] == false) {
						break;
					}
					if (j == 4) {
						bingo++;
					}
				}
			}

			// 대각
			for (int i = 0; i < 6; i++) {
				if (i == 5) {
					bingo++;
					break;
				}
				if (visited[i][i] == false) {
					break;
				}
			}
			for (int i = 0; i < 6; i++) {
				if (i == 5) {
					bingo++;
					break;
				}
				if (visited[4 - i][i] == false) {
					break;
				}
			}

			if (bingo >= 3) {
				System.out.println(cnt);
				return;
			}

		}
	}

}
