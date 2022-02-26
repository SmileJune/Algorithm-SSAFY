package com.ssafy.yun;

import java.util.Scanner;

public class JO_1037 {

	static Scanner sc = new Scanner(System.in);
	static int idxRow, idxCol;

	public static void main(String[] args) {
		int N = sc.nextInt();
		int[][] map = new int[N + 1][N + 1];
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int result = parity(map);
		if (result == 0) {
			System.out.println("Corrupt");
			return;
		}
		if (result == 1) {
			System.out.println("OK");
			return;
		}

		System.out.printf("Change bit (%d,%d)%n", idxRow, idxCol);
	}

	static int parity(int[][] map) {
		int cntRow = 0;
		int cntCol = 0;
		for (int i = 0; i < map.length; i++) {
			int sum = 0;
			for (int j = 0; j < map[i].length; j++) {
				sum += map[i][j];
			}
			if (sum % 2 == 1) {
				cntRow++;
				idxRow = i;
			}
			if (cntRow > 1) {
				return 0;
			}
		}
		for (int i = 0; i < map.length; i++) {
			int sum = 0;
			for (int j = 0; j < map[i].length; j++) {
				sum += map[j][i];
			}
			if (sum % 2 == 1) {
				cntCol++;
				idxCol = i;
			}
			if (cntCol > 1) {
				return 0;
			}
		}

		if (cntRow == 1 && cntCol == 1) {
			return 2;
		}

		if (cntRow == 0 && cntCol == 0) {
			return 1;
		}

		return 0;
	}

}
