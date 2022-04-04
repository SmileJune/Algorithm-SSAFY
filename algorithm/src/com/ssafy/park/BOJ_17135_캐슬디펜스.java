package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스 {
	static int[][] arr;
	static int[][] arrcopy;
	static boolean[][] target;
	static int[] archor;
	static int[] sel;
	static int N, M, D, starty;
	static int cnt = 0;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		starty = N - 1;
		archor = new int[3];
		sel = new int[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			sel[i] = i;
		}
		comb(0, 0);
		System.out.println(max);
	}

	public static void comb(int idx, int sidx) {
		if (sidx == 3) {
			cnt = 0;
			target = new boolean[N][M];
			arrcopy = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arrcopy[i][j] = arr[i][j];
				}
			}
			for (int i = starty; i >= 0; i--) {
				kill(archor[0], i);
				kill(archor[1], i);
				kill(archor[2], i);
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < M; k++) {
						if (target[j][k]) {
							arrcopy[j][k] = 0;
						}
					}
				}
			}
			max = Math.max(max, cnt);

			return;
		} else {
			for (int i = idx; i <= M - 3 + sidx; i++) {
				archor[sidx] = sel[i];
				comb(i + 1, sidx + 1);
			}
		}

	}

	public static void kill(int idx, int starty) {
		int dif = 0;
		int range = D;
		outer: while (range > 0) {
			int x = idx - dif;
			int y = starty;
			while (x < M && y <= starty) {
				if (x < 0 || y < 0) {
					if (x < idx) {
						y--;
					} else {
						y++;
					}
					x++;
					continue;
				}
				if (arrcopy[y][x] == 1) {
					if (!target[y][x]) {
						cnt++;
						target[y][x] = true;
					}
					break outer;
				}
				if (x < idx) {
					y--;
				} else {
					y++;
				}
				x++;
			}
			dif++;
			range--;
		}

	}
}
