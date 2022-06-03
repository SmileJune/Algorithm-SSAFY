package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day19SW1979어디에단어 { // 1979
	static int[][] arr1, arr2;
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/an/input1979.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr1 = new int[N][N];
			arr2 = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					arr1[i][j] = n;
					arr2[j][i] = n;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					if (arr1[i][j] == 1) {
						int tmp1 = 0;
						while (j < N && arr1[i][j] == 1) {
							tmp1++;
							j++;
						}
						if (tmp1 == K)
							ans++;
					}
				for (int j = 0; j < N; j++)
					if (arr2[i][j] == 1) {
						int tmp2 = 0;
						while (j < N && arr2[i][j] == 1) {
							tmp2++;
							j++;
						}
						if (tmp2 == K)
							ans++;
					}

			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
