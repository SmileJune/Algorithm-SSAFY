package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day125BOJ17281완탐연습 {
	static int N, ans;
	static int[] ord;
	static int[][] rec;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());

		rec = new int[N][10];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++)
				rec[i][j] = Integer.parseInt(st.nextToken());
		}
		ans = 0;
		visited = new boolean[10];
		ord = new int[10];
		visited[4] = true;
		ord[4] = 1;
		perm(2);
		System.out.println(ans);
		br.close();
	}

	static void perm(int d) {
		if (d == 10) {
			play();
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				ord[i] = d;
				perm(d + 1);
				visited[i] = false;
			}
		}
	}

	static void play() {
		int rst = 0, bat = 1;
		for (int i = 0; i < N; i++) {
			int out = 0;
			int base = 0;
			while (out < 3) {
				int player = rec[i][ord[bat]];
				if (player == 0)
					out++;
				else {
					base = (base + 1) << player;
					rst += Integer.bitCount(base / 16);
					base %= 16;
				}
				bat = bat + 1 == 10 ? 1 : bat + 1;
			}
		}
		ans = Math.max(ans, rst);
	}
}
