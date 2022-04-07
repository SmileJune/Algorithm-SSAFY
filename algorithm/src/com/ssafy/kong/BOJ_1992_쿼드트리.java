package day0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_1992_쿼드트리 {
	static char[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new char[N][];
		for (int i = 0; i < N; ++i) {
			map[i] = sc.next().toCharArray();
		}
		division(0, 0, N);
		System.out.println(sb);

	}

	// ((110(0101))(0010)1(0001))
	static void division(int row, int col, int size) {
		if (check(row, col, size)) {
			sb.append(map[row][col]);
			return;
		}
		sb.append("(");
		// row + i * size / 2 , col + j * size / 2;
		int sSize = size / 2;
		for (int i = 0; i <= 1; ++i) {
			for (int j = 0; j <= 1; ++j) {
				division(row + i * sSize, col + j * sSize, sSize);
			}
		}
		sb.append(")");
	}

	private static boolean check(int row, int col, int size) {
		int num = map[row][col];
		for (int i = row; i < row + size; ++i) {
			for (int j = col; j < col + size; ++j) {
				if (num != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}