package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1220_Magnetic {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; ++t) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];

			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; ++j) {
					arr[j][i] = Integer.parseInt(st.nextToken()); // 가로세로 바꿔서 받음
				}
			}
			int cnt = 0;
			outer : for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if(arr[i][j] == 1) {
						while(arr[i][j] != 2) {
							j++;
							if(j == n) {
								continue outer;
							}
						}
						cnt++;
					}
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}