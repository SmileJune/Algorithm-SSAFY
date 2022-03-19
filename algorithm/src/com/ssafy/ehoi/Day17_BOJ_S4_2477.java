package com.ssafy.ehoi;

import java.util.Scanner;

public class Day17_BOJ_S4_2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[] len = new int[6];
		for (int i = 0; i < 6; i++) {
			sc.nextInt();
			len[i] = sc.nextInt();
		}

		// 가로 최댓값 구하기
		int oneMax = 0;
		int oneIdx = 0;
		for (int i = 0; i < 6; i = i + 2) {
			if (len[i] > oneMax) {
				oneMax = len[i];
				oneIdx = i;
			}
		}

		// 세로 최댓값 구하기
		int twoMax = 0;
		int twoIdx = 0;
		for (int i = 1; i < 6; i = i + 2) {
			if (len[i] > twoMax) {
				twoMax = len[i];
				twoIdx = i;
			}
		}

		int start = (oneIdx + 1) % 6 == twoIdx ? oneIdx : twoIdx;

		// 작은 네모는 start 부터 idx가 3, 4 떨어진 곳에 항상 존재해
		int smallMax = len[(start + 3) % 6] * len[(start + 4) % 6];

		System.out.println(((oneMax*twoMax)-smallMax)*T);

		sc.close();
	}
}
