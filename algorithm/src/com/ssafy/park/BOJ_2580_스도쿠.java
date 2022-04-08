package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠 {
	public static class point {
		int r, c;

		public point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[][] map;
	static List<point> list = new ArrayList<>();
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					list.add(new point(i, j));
				}
			}
		}
		solution(0);
		System.out.println(sb);
	}

	public static void solution(int idx) {
		if (idx == list.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (j == 8) {
						sb.append(map[i][j]);
					} else {
						sb.append(map[i][j] + " ");
					}
				}
				if (i != 8)	{					
					sb.append("\n");
				}
			}
			System.out.println(sb);
			System.exit(0);
		}
		int r = list.get(idx).r;
		int c = list.get(idx).c;
		for (int i = 1; i <= 9; i++) {
			map[r][c] = i;
			if (check(r, c)) {
				solution(idx + 1);
			}
		}
		map[r][c] = 0;
	}

	public static boolean check(int r, int c) {
		for (int i = 0; i < 9; i++) {
			if (i != c) {
				if (map[r][i] == map[r][c])
					return false;
			}
			if (i != r) {
				if (map[i][c] == map[r][c])
					return false;
			}
		}
		int tempr = (r / 3) *3;
		int tempc = (c / 3) *3;
		for (int i = tempr; i < tempr + 3; i++) {
			for (int j = tempc; j < tempc + 3; j++) {
				if (i != r && j != c) {
					if (map[r][c] == map[i][j])
						return false;
				}
			}
		}
		return true;
	}
}
