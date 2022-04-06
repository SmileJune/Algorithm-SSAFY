package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1247_최적경로 {
	public static class point {
		int r;
		int c;

		public point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N;
	static point work, house;
	static point[] client;
	static point[] sel;
	static boolean[] visited;
	static int min;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			client = new point[N];
			sel = new point[N];
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			work = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			house = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 0; i < N; i++) {
				client[i] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			perm(0);
			sb.append("#" + tc + " " + min + "\n");
		}
		System.out.println(sb);
	}

	public static int dist(point x, point y) {
		return Math.abs(x.r - y.r) + Math.abs(x.c - y.c);
	}

	public static void perm(int cnt) {
		if (cnt == N) {
			int sum = 0;
			sum += dist(work, sel[0]);
			for (int i = 0; i < sel.length - 1; i++) {
				sum += dist(sel[i], sel[i + 1]);
			}
			sum += dist(sel[sel.length - 1], house);
			min = Math.min(min, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			sel[cnt] = client[i];
			visited[i] = true;
			perm(cnt + 1);
			visited[i] = false;
		}
	}
}
