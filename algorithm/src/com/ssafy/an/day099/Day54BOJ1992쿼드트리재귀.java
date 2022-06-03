package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day54BOJ1992쿼드트리재귀 {
	static int[][] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = tmp.charAt(j) - '0';
			}
		}
		recur(0, 0, N);
		System.out.println(sb);
		br.close();
	}

	private static void recur(int idx, int jdx, int size) {
		if (check(idx, jdx, size)) {
			sb.append(arr[idx][jdx]);
			return;
		}
		int dsize = size / 2;
		sb.append("(");

		recur(idx, jdx, dsize);
		recur(idx, jdx + dsize, dsize);
		recur(idx + dsize, jdx, dsize);
		recur(idx + dsize, jdx + dsize, dsize);

		sb.append(")");
	}

	private static boolean check(int idx, int jdx, int size) {
		int c = arr[idx][jdx];
		for (int i = idx; i < idx + size; i++) {
			for (int j = jdx; j < jdx + size; j++) {
				if (arr[i][j] != c)
					return false;
			}
		}
		return true;
	}
}
