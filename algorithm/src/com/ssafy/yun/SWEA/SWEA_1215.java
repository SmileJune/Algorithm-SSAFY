package com.ssafy.yun.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1215 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static char[][] arr = new char[8][8];
	public static int len;

	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int tc = 1; tc <= 10; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	public static int solution() throws NumberFormatException, IOException {

		len = Integer.parseInt(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		return checkRow() + checkColumn();
	}

	public static int checkRow() {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length - len + 1; j++) {
				boolean flag = true;
				for (int k = 0; k < len / 2; k++) {
					if (arr[i][j + k] != arr[i][(len - 1) + j - k]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					cnt++;
				}
			}
		}

		return cnt;

	}

	public static int checkColumn() {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length - len + 1; j++) {
				boolean flag = true;
				for (int k = 0; k < len / 2; k++) {
					if (arr[j + k][i] != arr[(len - 1) + j - k][i]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					cnt++;
				}
			}
		}

		return cnt;
	}

}
