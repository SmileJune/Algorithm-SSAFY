package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day121BOJ10159저울FloydWarshall공부 { // 10159 저울 플로이드 와샬
	static int N, M;
	static boolean[][] arr, rra;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new boolean[N][N];
		rra = new boolean[N][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;

			arr[u][v] = true;
			rra[v][u] = true;
		}

		// 플로이드 와샬 알고리즘
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][k] && arr[k][j])
						arr[i][j] = true;
					if (rra[i][k] && rra[k][j])
						rra[i][j] = true;
				}
			}
		}

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				arr[i][j] |= rra[i][j];

		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (!arr[i][j])
					cnt++;
			}
			sb.append(cnt + "\n");
		}

		System.out.println(sb);
		br.close();
	}
}
