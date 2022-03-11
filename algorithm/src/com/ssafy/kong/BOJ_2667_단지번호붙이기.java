package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_2667_단지번호붙이기 {
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static int N;
	static int[] aparts = new int[25 * 25];
	static int apartNum = 0;

	static int[][] map;
	static boolean[][] mapVisit;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		mapVisit = new boolean[N][N];
		list = new ArrayList<Integer>();
		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			for (int j = 0; j < N; ++j) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (!mapVisit[i][j] && map[i][j] == 1) {
					apartNum++;
					solution(i, j);
				}
			}
		}

		Arrays.sort(aparts);
		System.out.println(apartNum);

		for (int i = 0; i < aparts.length; i++) {
			if (aparts[i] != 0) {
				System.out.println(aparts[i]);
			} 
		}
	}

	static void solution(int i, int j) {
		mapVisit[i][j] = true;
		aparts[apartNum]++;
		for (int k = 0; k < 4; ++k) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			if (nr >= 0 &&  nr < N && nc >= 0 && nc < N) {
				if (!mapVisit[nr][nc] && map[nr][nc] == 1) {
					solution(nr, nc);
				}
			}
		}
	}
}