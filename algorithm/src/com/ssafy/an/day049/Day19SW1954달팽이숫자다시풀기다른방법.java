package com.ssafy.an.day049;

import java.util.Arrays;
import java.util.Scanner;

public class Day19SW1954달팽이숫자다시풀기다른방법 { // 1954 달팽이 숫자
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int cnt = 1;
			int st = 0;
			int ed = N;
			while (cnt <= N * N) {
				for (int j = st; j < ed; j++) {
					arr[st][j] = cnt++;
				}

				for (int i = st + 1; i < ed; i++) {
					arr[i][ed - 1] = cnt++;
				}
				ed--;				

				for (int j = ed - 1; j >= st; j--) {
					arr[ed][j] = cnt++;
				}
				
				for (int i = ed - 1; i > st; i--) {
					arr[i][st] = cnt++;
				}
				st++;
				
			}
			sb.append("#").append(tc).append("\n");
			for (int i = 0; i < N; i++) {
				sb.append(Arrays.toString(arr[i]).replaceAll("[\\[\\]\\,]", "")).append("\n");
			}
		}
		System.out.println(sb);
		sc.close();
	}
}
