package com.ssafy.yun.Baek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Baek_15686 {
	static int[] sel;
	static List<Integer> rows, cols;
	static int[][] map;
	static int n, m, min, oriNum;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		min = Integer.MAX_VALUE;

		rows = new ArrayList<>();
		cols = new ArrayList<>();
		// 선택된 것들 담을 배열
		sel = new int[m];

		// 맵 만들고
		map = new int[n + 1][n + 1];
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) {
					oriNum++;
					rows.add(i);
					cols.add(j);
				}
			}
		}
		comb(0, 0);

		System.out.println(min);
	}

	static void comb(int idx, int sidx) {
		if (sidx == m) {
			check();
			return;
		}

		for (int i = idx; i < oriNum; i++) {
			sel[sidx] = i;
			comb(i + 1, sidx + 1);
		}
	}

	static void check() {
		int dis = 0;
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				if (map[i][j] == 1) {
					dis += checkEachDis(i, j);
				}
			}
		}
		min = Math.min(min, dis);
	}

	static int checkEachDis(int i, int j) {
		int eachDis = Integer.MAX_VALUE;
		for (int k = 0; k < sel.length; k++) {
			eachDis = Math.min(eachDis, Math.abs(rows.get(sel[k]) - i) + Math.abs(cols.get(sel[k]) - j));
		}
		return eachDis;
	}
}
