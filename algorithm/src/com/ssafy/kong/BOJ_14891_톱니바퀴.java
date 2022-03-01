package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14891_톱니바퀴 {
	static int[][] gear;
	static int[] dirArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gear = new int[4][8];
		StringTokenizer st;
		for (int i = 0; i < 4; ++i) {
			String str = br.readLine();
			for (int j = 0; j < 8; ++j) {
				gear[i][j] = str.charAt(j) - '0';
			}
		}
		int k = Integer.parseInt(br.readLine()); // 회전횟수.
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken())-1; // 회전시킨 톱니바퀴의 번호
			int d = Integer.parseInt(st.nextToken()); // 방향
			dirArr = new int[4];
			dirArr[n] = d;
			checkLeft(n, d * -1); // 좌측 탐색
			checkRight(n, d * -1); // 우측 탐색
			for (int i = 0; i < 4; i++)
				rotate(i, dirArr[i]);
		}

		int ans = 0;
		for (int i = 0; i < 4; ++i) {
			if (gear[i][0] == 1) {
				ans += Math.pow(2, i);
			}
		}
		System.out.println(ans);
	}

	public static void checkRight(int left, int d) {
		int right = left + 1;
		if (right > 3)
			return;
		if (gear[left][2] != gear[right][6]) {
			dirArr[right] = d;
			checkRight(right, d * -1);
		}
	}

	public static void checkLeft(int rihgt, int d) {
		int left = rihgt - 1;
		if (left < 0)
			return;
		if (gear[left][2] != gear[rihgt][6]) {
			dirArr[left] = d;
			checkLeft(left, d * -1);
		}
	}

	public static void rotate(int idx, int d) {
		int tmp = 0;
		if (d == 1) {
			tmp = gear[idx][7];
			for (int i = gear[idx].length - 1; i > 0; i--) {
				gear[idx][i] = gear[idx][i - 1];
			}
			gear[idx][0] = tmp;
		} else if(d == -1) {
			tmp = gear[idx][0];
			for (int i = 0; i < gear[idx].length - 1; i++) {
				gear[idx][i] = gear[idx][i + 1];
			}

			gear[idx][7] = tmp;
		}
	}

}