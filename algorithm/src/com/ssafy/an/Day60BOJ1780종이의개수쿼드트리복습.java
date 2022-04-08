package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day60BOJ1780종이의개수쿼드트리복습 { // 1780 종이의 개수 쿼드트리 재귀 복습
	static int N, map[][], ans[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		ans = new int[3]; // -1, 0, 1

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) + 1;
			} // -1, 0, 1 > 0, 1, 2
		}

		recur(0, 0, N);

		System.out.println(ans[0] + "\n" + ans[1] + "\n" + ans[2]);
		br.close();
	}

	private static void recur(int idx, int jdx, int size) {
		if (check(idx, jdx, size)) {
			ans[map[idx][jdx]]++;
			return;
		}
		int ns = size / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				recur(idx + ns * i, jdx + ns * j, ns);
			}
		}
	}

	private static boolean check(int idx, int jdx, int size) {
		for (int i = idx; i < idx + size; i++) {
			for (int j = jdx; j < jdx + size; j++) {
				if (map[i][j] != map[idx][jdx])
					return false;
			}
		}
		return true;
	}
}
