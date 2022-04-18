package com.ssafy.yun.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14889 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static boolean[] visited;
	static int N, ans;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;
		visited = new boolean[N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, 0);
		System.out.println(ans);
	}

	// 두가지로 나누는 경우 true, false로 구분하네!
	static void comb(int idx, int cnt) {
		if (cnt == N / 2) {
			check();
			return;
		}

		for (int i = idx; i < N; i++) {
			if (visited[i] == true)
				continue;
			visited[i] = true;
			comb(i + 1, cnt + 1);
			visited[i] = false;
		}
	}

	private static void check() {
		int start = 0;
		int link = 0;

		for (int i = 0; i <= N - 2; i++) {
			for (int j = i + 1; j <= N - 1; j++) {
				if (visited[i] && visited[j]) {
					start += (map[i][j] + map[j][i]);
				} else if (!visited[i] && !visited[j]) {
					link += (map[i][j] + map[j][i]);
				}
			}
		}

		int dis = Math.abs(start - link);
		if (dis == 0) {
			System.out.println(0);
			System.exit(0);
		}
		ans = Math.min(ans, dis);
	}
}
