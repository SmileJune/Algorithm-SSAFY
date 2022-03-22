package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7964_부먹왕국의차원관문 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int[] city = new int[N + 2];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; ++i) {
				city[i] = Integer.parseInt(st.nextToken());
			}
			city[0] = 1;
			city[N + 1] = 1;
			int ans = 0;
			for (int i = 0; i <= N + 1; ++i) {
				if (city[i] == 1) {
					for (int j = i + 1; j <= i + D && j < N + 1; ++j) {
						if (city[j] == 1) {
							i = j-1;
							break;
						}
						if (j == i + D) {
							ans++;
							i = j;
						}
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}