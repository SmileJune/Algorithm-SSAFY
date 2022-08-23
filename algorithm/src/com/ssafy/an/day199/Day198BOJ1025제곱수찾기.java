package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day198BOJ1025제곱수찾기 {
	private static int n;
	private static int m;
	private static int[][] table;
	private static int max = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		n = input.charAt(0) - '0';
		m = input.charAt(2) - '0';
		table = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				table[i][j] = str.charAt(j) - '0';
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				checkSquare(table[i][j]);
				makeNum(i, j);
			}
		}
		System.out.print(max);
		br.close();
	}

	private static void makeNum(int row, int col) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 방향 설정
				int dr = i - row;
				int dc = j - col;
				if (dr == 0 && dc == 0)
					continue;
				appendNum(row + dr, col + dc, dr, dc, table[row][col]);
			}
		}
	}

	private static void appendNum(int row, int col, int dr, int dc, int num) {
		if (row < 0 || row >= n || col < 0 || col >= m)
			return;
		int newNum = 10 * num + table[row][col];
		checkSquare(newNum);
		appendNum(row + dr, col + dc, dr, dc, newNum);
	}

	private static void checkSquare(int num) {
		int sqrt = (int) Math.sqrt(num);
		if (sqrt * sqrt == num && num > max)
			max = num;
	}

}