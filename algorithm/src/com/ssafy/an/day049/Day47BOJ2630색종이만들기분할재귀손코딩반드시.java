package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day47BOJ2630색종이만들기분할재귀손코딩반드시 { // 2630 색종이 만들기 분할 재귀, 손코딩 반드시 해보기
	static int N, W = 0, B = 0;
	static boolean[][] bw;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		bw = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				bw[i][j] = st.nextToken().equals("1");
			}
		}

		recur(0, 0, N);

		System.out.println(W + "\n" + B);
		br.close();
	}

	private static void recur(int r, int c, int size) {
		if (check(r, c, size)) {
			if (!bw[r][c])
				W++;
			else
				B++;
			return;
		}
		int n = size / 2;
		recur(r, c, n);
		recur(r, c + n, n);
		recur(r + n, c, n);
		recur(r + n, c + n, n);
	}

	private static boolean check(int r, int c, int size) {
		boolean chk = bw[r][c];
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (bw[i][j] != chk)
					return false;
			}
		}
		return true;
	}
}
