package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day12_BOJ_2567 { // 2567
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[][] map = new int[101][101];

		int N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for (int i = r; i < r + 10; i++) {
				for (int j = c; j < c + 10; j++) {
					map[i][j] = 1;
				}
			}
		}

		int cnt = 0; // 한 칸, 한 변의 길이 1
		for (int i = 0; i < 100; i++) { // i+1값 탐색 고려
			for (int j = 0; j < 101; j++) { // 고정값
				if (map[i][j] != map[i + 1][j])
					cnt++;
				if (map[j][i] != map[j][i + 1])
					cnt++;
			}
		}

		System.out.println(cnt);
	}
}
