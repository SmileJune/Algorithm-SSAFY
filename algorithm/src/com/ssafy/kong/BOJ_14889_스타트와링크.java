package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
	static int[][] arr;
	static int N;
	static boolean[] num;
	static int ans = 0;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st;

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		num = new boolean[N];
		for (int i = 0; i < N; ++i) {
			num[i] = false;
		}

		recur(0, 0);
		System.out.println(min);
	}

	static void recur(int idx, int cnt) {
		if (cnt == N / 2) {
			find();
		}

		for(int i = idx; i < N; ++i) {
			if(!num[i]) {
				num[i] = true;
				recur(i+1, cnt+1);
			}
			num[i] = false;
		}
	}

	static void find() {
		int teamStart = 0;
		int teamLink = 0;
		for (int i = 0; i < N - 1; ++i) {
			for (int j = i + 1; j < N; ++j) {
				if (num[i] && num[j]) {
					teamStart += arr[i][j];
					teamStart += arr[j][i];
				} else if (!num[i] && !num[j]) {
					teamLink += arr[i][j];
					teamLink += arr[j][i];
				}
			}

		}
		min = Math.min(min, Math.abs(teamStart - teamLink));
	}
}