package com.ssafy.hwang;

import java.util.Scanner;

public class Day17_BOJ_롤케이크 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int L = sc.nextInt();
		int N = sc.nextInt();
		int[][] people = new int[N + 1][2];
		int predictMax = Integer.MIN_VALUE;
		for (int i = 1; i < people.length; i++) {
			for (int j = 0; j < 2; j++) {
				people[i][j] = sc.nextInt();
			}
			predictMax = Math.max(predictMax, (people[i][1] - people[i][0]) + 1);

		}
		for (int i = 1; i < people.length; i++) {
			if (predictMax == (people[i][1] - people[i][0]) + 1) {
				sb.append(i + "\n");
				break;
			}
		}

		int[] check = new int[L + 1];
		for (int i = 1; i < people.length; i++) {
			for (int j = people[i][0]; j <= people[i][1]; j++) {
				if (check[j] == 0) {
					check[j] = i;
				}
			}
		}
		int[] factMin = new int[N + 1];
		int resultIdx = 0;
		int result = 0;
		for (int i = 1; i < check.length; i++) {
			if (check[i] != 0)
				factMin[check[i]]++;
		}
		for (int i = 1; i < factMin.length; i++) {
			if (result < factMin[i]) {
				result = factMin[i];
				resultIdx = i;
			}

		}
		sb.append(resultIdx);

		System.out.println(sb.toString());
	}
}
