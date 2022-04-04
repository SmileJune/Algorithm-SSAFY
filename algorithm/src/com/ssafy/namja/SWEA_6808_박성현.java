package com.ssafy.namja;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_6808_박성현 {
	static int N;
	static int[] gyu_deck;
	static int[] in_deck;
	static int[] result;
	static boolean[] visited;
	static int win;
	static int lose;
	static int num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			boolean[] included = new boolean[19]; // 1 ~ 18, 0은 무시 
			gyu_deck = new int[9];
			in_deck = new int[9];
			result = new int[9];
			visited = new boolean[9];
			for (int i = 0; i < 9; i++) {
				int num = sc.nextInt();
				gyu_deck[i] = num;
				included[num] = true;
			}
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (included[i])
					continue;
				in_deck[idx++] = i;
			}
			win = 0;
			lose = 0;
			perm(0);
			System.out.printf("#%d %d %d\n", t, win, lose);
		}
	}
	
	static void perm(int idx) {
		if (idx == 9) {
			num = 0;
			for (int i = 0; i < 9; i++) {
				int sum = gyu_deck[i] + result[i];
				num += (gyu_deck[i] > result[i] ? sum : -sum);
			}
			if (num > 0) win++;
			if (num < 0) lose++;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (visited[i])
				continue;
			result[idx] = in_deck[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}
}