package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Day64BOJ11780플로이드마샬이뭔데 { // 11780 플로이드 2
	static final int INF = 1000001;
	static StringBuilder sb;
	static int N, M;
	static int[][] cost, route;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		cost = new int[N + 1][N + 1];
		route = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (i != j)
					cost[i][j] = 1000001;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			cost[x][y] = Math.min(cost[x][y], Integer.parseInt(st.nextToken()));
			route[x][y] = x;
		}

		for (int k = 1; k < N + 1; k++) { // 구선생님..
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (cost[i][j] > cost[i][k] + cost[k][j]) {
						cost[i][j] = cost[i][k] + cost[k][j];
						route[i][j] = route[k][j];
					}
				}
			}
		}
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (cost[i][j] < 100000) {
					sb.append(cost[i][j] + " ");
				} else {
					sb.append("0 ");
				}
			}
			sb.append("\n");
		}

		for (int i = 1; i < N + 1; i++) {
			path(i, N);
		}

		System.out.println(sb);
		br.close();
	}

	public static void path(int start, int n) { // 구선생님..
		Stack<Integer> st;
		for (int end = 1; end < n + 1; end++) {
			if (start == end)
				sb.append("0" + "\n");
			else {
				st = new Stack<>();
				int idx = route[start][end];
				while (idx != 0) {
					st.push(idx);
					idx = route[start][idx];
				}

				if (st.isEmpty()) { // start에서 end로 갈 수 없는 경우
					sb.append("0" + "\n");
				} else { // 경로 출력
					sb.append((st.size() + 1) + " ");
					while (!st.isEmpty()) {
						sb.append(st.peek() + " ");
						st.pop();
					}
					sb.append(end + "\n");
				}
			}
		}
	}
}
