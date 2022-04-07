package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_2112_보호필름 {
	static int D, W, k;
	static int[][] map;
	static boolean[] sel;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			sb.append("#" + tc + " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			sel = new boolean[D];
			min = k;
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if (test(map)) {
				sb.append(0 + "\n");
			} else {
				injection(0, 0);
				sb.append(min + "\n");
			}
		}
		System.out.println(sb);
	}

	public static void injection(int k, int cnt) {
		if (D == k) {
			boolean[] bo = new boolean[cnt];
			coll(sel, bo, cnt, 0);
			return;
		}
		if (cnt >= min) return;
		sel[k] = false;
		injection(k + 1, cnt);
		sel[k] = true;
		injection(k + 1, cnt+1);
	}

	public static void coll(boolean[] sel, boolean[] bo, int n, int k) {
		if (n == k) {
			int[][] mapcopy = new int[D][W];
			for (int i = 0; i < D; i++) {
				System.arraycopy(map[i], 0, mapcopy[i], 0, map[i].length);
			}
			int idx = 0;
			for (int i = 0; i < D; i++) {
				if (sel[i]) {
					if (bo[idx]) {
						Arrays.fill(mapcopy[i], 0);
					} else {
						Arrays.fill(mapcopy[i], 1);
					}
					idx++;
				}
			}
			if (test(mapcopy)) {
				min = Math.min(min, bo.length);
			}
			return;
		}
		bo[k] = false;
		coll(sel, bo, n, k + 1);
		bo[k] = true;
		coll(sel, bo, n, k + 1);
	}

	public static boolean test(int[][] map) {
		for (int i = 0; i < W; i++) {
			boolean bo = false;
			int cnt = 0;
			int temp = -1;
			for (int j = 0; j < D; j++) {
				if (temp != map[j][i]) {
					cnt = 1;
					temp = map[j][i];
				} else {
					cnt++;
				}
				if (cnt == k)
					bo = true;
			}
			if (!bo)
				return false;
		}
		return true;
	}
}
