package com.ssafy.yun.SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_6808 {

	static int[] arr1, arr2;
	static boolean[] visited;
	static int n;
	static Scanner sc = new Scanner(System.in);
	static StringBuffer sb;
	static int arr1Win, arr2Win;

	public static void main(String[] args) {
		n = 18;
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuffer();
			sb.append("#").append(tc).append(" ");
			solution();
			System.out.println(sb);
		}
	}

	static void solution() {
		arr1 = new int[n / 2];
		arr2 = new int[n / 2];
		visited = new boolean[n + 1];
		arr1Win = 0;
		arr2Win = 0;
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = sc.nextInt();
			visited[arr1[i]] = true;
		}
		perm(0);
		sb.append(arr1Win).append(" ");
		sb.append(arr2Win);

	}

	static void perm(int idx) {
		if (n / 2 == idx) {
			check();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (visited[i]) {
				continue;
			}

			arr2[idx] = i;
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;

		}
	}

	static void check() {
		int score1 = 0;
		int score2 = 0;

		for (int i = 0; i < arr1.length; i++) {
			int sum = arr1[i] + arr2[i];
			if (arr1[i] > arr2[i]) {
				score1 += sum;
			}
			if (arr1[i] < arr2[i]) {
				score2 += sum;
			}
		}
		if (score1 > score2) {
			arr1Win++;
		}
		if (score1 < score2) {
			arr2Win++;
		}
	}

}
