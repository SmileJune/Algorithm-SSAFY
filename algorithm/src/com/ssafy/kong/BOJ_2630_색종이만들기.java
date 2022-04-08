package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이만들기 {
	static int[][] paper;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		paper = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		division(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}

	static int white;
	static int blue;

	static void division(int row, int col, int size) {
		if (check(row, col, size)) {
			if (paper[row][col] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}
		int mid = size / 2;
		division(row, col, mid);
		division(row, col + mid, mid);
		division(row + mid, col, mid);
		division(row + mid, col + mid, mid);
	}

	private static boolean check(int row, int col, int size) {
		int color = paper[row][col];
		for (int i = row; i < size + row; ++i) {
			for (int j = col; j < size + col; ++j) {
				if (color != paper[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
