package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {
	static class Point {
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N, M;
	static int[][] arr;
	static List<Point> chicken = new ArrayList<>();
	static List<Point> house = new ArrayList<>();
	static Point[] sel;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		sel = new Point[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				if (num == 2) {
					chicken.add(new Point(i,j));
				}
				if (num == 1) {
					house.add(new Point(i,j));
				}
			}
		}
		comb(0, 0);
		System.out.println(ans);
	}

	public static void comb(int idx, int start) {
		if (idx == M) {
			check();
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			sel[idx] = chicken.get(i);
			comb(idx + 1, i + 1);
		}
	}

	public static void check() {
		int sum = 0;
		for (int i = 0; i < house.size(); i++) {
			int r = house.get(i).r;
			int c = house.get(i).c;
			int min = Integer.MAX_VALUE;
			for (int k = 0; k < M; k++) {
				int temp = Math.abs(r - sel[k].r)
						+ Math.abs(c - sel[k].c);
				min = Math.min(min, temp);
			}
			sum += min;

		}
		ans = Math.min(ans, sum);
	}
}
