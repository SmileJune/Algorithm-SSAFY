package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2115_벌꿀채취 {
	static int N, M, C;
	static int[][] map;
	static int[] idx;
	static int[] selr;
	static int[] selc;
	static boolean[] sel;
	static int max;
	static int maxsum;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			idx = new int[N];
			selr = new int[2];
			selc = new int[2];
			sel = new boolean[M];
			ans = 0;
			for (int i = 0; i < N; i++) {
				idx[i] = i;
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			selectr(0, 0);
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	public static void selectr(int cnt, int start) {
		if (cnt == 2) {
			maxsum = 0;
			selectc(selr, 0, 0);
			ans = Math.max(ans, maxsum);
			return;
		}
		if (N >= 2 * M) {
			for (int i = start; i < N; i++) {
				selr[cnt] = idx[i];
				selectr(cnt + 1, i);
			}
		} else {
			for (int i = start; i < N; i++) {
				selr[cnt] = idx[i];
				selectr(cnt + 1, i + 1);
			}
		}
	}

	public static void selectc(int[] arr, int cnt, int start) {
		if (cnt == 2) {
			int sum = 0;
			for (int i = 0; i < 2; i++) {
				max = 0;
				check(arr[i], selc[i], M, 0);
				sum += max;
			}
			maxsum = Math.max(maxsum, sum);
			return;
		}
		if (arr[0] == arr[1]) {
			for (int i = start; i <= N - M; i += M) {
				selc[cnt] = idx[i];
				selectc(arr, cnt + 1, i + M);
			}
		} else {
			for (int i = start; i <= N - M; i++) {
				selc[cnt] = idx[i];
				selectc(arr, cnt + 1, start);
			}
		}
	}

	public static void check(int r, int c, int n, int k) {
		if (n == k) {
			int temp = 0;
			for (int i = 0; i < M; i++) {
				if (sel[i]) {
					temp += map[r][c + i];
				}
			}
			if (temp > C)
				return;
			else {
				temp = 0;
				for (int i = 0; i < M; i++) {
					if (sel[i]) {
						temp += Math.pow(map[r][c + i], 2);
					}
				}
				max = Math.max(max, temp);
			}
			return;
		}
		sel[k] = false;
		check(r, c, n, k + 1);
		sel[k] = true;
		check(r, c, n, k + 1);
	}
}
