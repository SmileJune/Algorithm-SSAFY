package com.ssafy.an;

import java.util.Arrays;
import java.util.Scanner;

public class Day38BOJ2447별찍기재귀 { // 2447 별 찍기 재귀
	static char[][] star;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		star = new char[N][N];
		star(0, 0, N, false);
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(star[i]).replaceAll("[\\[\\]]", "").replaceAll(", ", ""));
		}
		sc.close();
	}

	static void star(int idx, int jdx, int n, boolean b) {
		if (b) {
			for (int i = idx; i < idx + n; i++) {
				for (int j = jdx; j < jdx + n; j++) {
					star[i][j] = ' ';
				}
			}
			return;
		}
		if (n == 1) {
			star[idx][jdx] = '*';
			return;
		}

		int size = n / 3;
		int count = 0;
		for (int i = idx; i < idx + n; i += size) {
			for (int j = jdx; j < jdx + n; j += size) {
				count++;
				if (count == 5)
					star(i, j, size, true);
				else
					star(i, j, size, false);
			}
		}
	}
}
