package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day52BOJ11404플로이드 { // 11404 하다 말았음.
	static final int INF = (int) 1e9; // 플로이드 함수를 위한 큰 값, MAX_VALUE 안됨
	static int N, M;
	static int[][] dist;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		dist = new int[N + 1][N + 1];
		sb = new StringBuilder();

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (i == j)
					continue;
				dist[i][j] = INF;
			}
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int stt = Integer.parseInt(st.nextToken());
			int ed = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			dist[stt][ed] = Math.min(dist[stt][ed], cost);
		}

		floyd();
		System.out.println(sb);
		br.close();
	}

	private static void floyd() {
		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
				}
			}
		}
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (dist[i][j] >= INF)
					sb.append("0 ");
				else
					sb.append(dist[i][j] + " ");
			}
			sb.append("\n");
		}
	}
}
