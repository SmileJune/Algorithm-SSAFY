package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day8Main_BOJ_10163 { // 10163
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] arr = new int[1002][1002];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int i = x1; i < x1 + x2; i++) {
				for (int j = y1; j < y1 + y2; j++) {
					arr[i][j] = n + 1; // 각 색종이를 상수로 덮기
				}
			}
		}

		for (int n = 0; n < N; n++) {
			int cnt = 0;
			for (int i = 0; i < 1002; i++) {
				for (int j = 0; j < 1002; j++) {
					if (arr[i][j] == n + 1)
						cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}
}
