package com.ssafy.park;

import java.util.Scanner;

public class BOJ_11724_연결요소의개수 {
	static int N, M, cnt;
	static boolean bo[];
	static boolean map[][];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		bo = new boolean[N + 1];
		map = new boolean[N + 1][N + 1];
		cnt = 0;
		for (int i = 1; i <= M; i++) {
			int tmp1 = sc.nextInt();
			int tmp2 = sc.nextInt();

			map[tmp1][tmp2] = true;
			map[tmp2][tmp1] = true;

		}

		for (int i = 1; i <= N; i++) {
			if (!bo[i]) {
				dfs(i);
				cnt++;
			}
		}

		System.out.println(cnt);

	}

	private static void dfs(int start) {
		bo[start] = true;

		for (int i = 1; i <= N; i++) {
			if (map[start][i] && !bo[i]) {
				dfs(i);
			}
		}
	}
}
