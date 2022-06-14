package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day127BOJ11403경로찾기플로이드와샬 { // 11403 경로찾기 플로이드 와샬
	static int N;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int k = 0; k < N; k++)
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					if (map[i][k] == 1 && map[k][j] == 1)
						map[i][j] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sb.append(map[i][j]).append(" ");
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}
}
