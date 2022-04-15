package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_2383_점심식사시간 {
	static int N, ans;
	static int[][] map;
	static List<int[]> people, stair;
	static int[] sel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			people = new ArrayList<int[]>();
			stair = new ArrayList<int[]>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						people.add(new int[] { i, j });
					}
					if (map[i][j] > 1) {
						stair.add(new int[] { i, j, map[i][j] });
					}
				}
			}
			ans = Integer.MAX_VALUE;
			sel = new int[people.size()];
			perm(0, 0);
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	public static void perm(int idx, int sidx) {
		if (idx == people.size()) {
			ans = Math.min(ans, down());
			return;
		}
		for (int i = sidx; i < 2; i++) {
			sel[idx] = i;
			perm(idx + 1, sidx);
		}
	}

	public static int down() {
		int[] distArr = new int[people.size()];
		for (int i = 0; i < sel.length; i++) {
			int[] tempP = people.get(i);
			int[] tempS = stair.get(sel[i]);
			distArr[i] = dist(tempP[0], tempP[1], tempS[0], tempS[1]);
		}
		int cnt0 = 0;
		int cnt1 = 0;
		int time = 0;
		int num = people.size();
		while (num > 0) {
			time++;
			for (int i = 0; i < sel.length; i++) {
				distArr[i]--;
				if (sel[i] == 0) {
					if (distArr[i] == -1 * stair.get(0)[2] - 1) {
						cnt0--;
						num--;
					}
				} else {
					if (distArr[i] == -1 * stair.get(1)[2] - 1) {
						cnt1--;
						num--;
					}
				}
			}
			for (int i = 0; i < sel.length; i++) {
				if (sel[i] == 0) {
					if (distArr[i] == -1) {
						if (cnt0 == 3) {
							distArr[i]++;
						} else {
							cnt0++;
						}
					}
				} else {
					if (distArr[i] == -1) {
						if (cnt1 == 3) {
							distArr[i]++;
						} else {
							cnt1++;
						}
					}
				}
			}
		}
		return time;
	}

	public static int dist(int r1, int c1, int r2, int c2) {
		return Math.abs((r1 - r2)) + Math.abs(c1 - c2);
	}
}
