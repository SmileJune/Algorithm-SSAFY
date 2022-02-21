package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day13_BOJ_1244 { // 1244
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int male = Integer.parseInt(st.nextToken());
			int sw = Integer.parseInt(st.nextToken());
			if (male == 1) {
				for (int n = 1; n <= N; n++) {
					if (n % sw == 0) {
						arr[n] = (arr[n] + 1) % 2;
					}
				}
			} else {
				arr[sw] = (arr[sw] + 1) % 2;
				for (int j = 1; j < N + 1 / 2; j++) {
					if (sw + j > N || sw - j < 1)
						break;
					if (arr[sw - j] == arr[sw + j]) {
						arr[sw - j] = (arr[sw] - j) % 2;
						arr[sw + j] = (arr[sw] + j) % 2;
					} else
						break;
				}
			}
		}
		int line = 20;
		for (int n = 1; n <= N; n++) {
			System.out.print(arr[n] + " ");
			line--;
			if (line == 0) {
				System.out.println();
				line = 20;
			}

		}
		br.close();
	}
}
