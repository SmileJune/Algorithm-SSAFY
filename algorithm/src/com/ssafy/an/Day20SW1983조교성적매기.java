package com.ssafy.an;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day20SW1983조교성적매기 { // 1983 조교성적매기기
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/an/input1983.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		String[] grade = { "D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+" };

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][1] = i;
				arr[i][0] = Integer.parseInt(st.nextToken()) * 35 + Integer.parseInt(st.nextToken()) * 45
						+ Integer.parseInt(st.nextToken()) * 20;
			}

			for (int i = N - 1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					if (arr[j][0] > arr[j + 1][0]) {
						int[] tmp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = tmp;
					}
				}
			}

			String ans = "";
			for (int i = 0; i < N; i++) {
				if (arr[i][1] == K - 1) { // 번째
					ans = grade[i / (N / 10)];
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
