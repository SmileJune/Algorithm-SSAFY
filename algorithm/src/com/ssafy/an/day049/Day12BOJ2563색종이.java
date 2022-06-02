package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day12BOJ2563색종이 { // 2563
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int size = 101;
		int[][] arr = new int[size][size];
		int ans = 0;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for (int i = r; i < r + 10; i++) {
				for (int j = c; j < c + 10; j++) {
					arr[i][j] = 1;
				}
			}
		}
		for (int i = 1; i < size; i++) {
			for (int j = 1; j < size; j++) {
				ans += arr[i][j];
			}
		}
		System.out.println(ans);
		br.close();
	}
}
