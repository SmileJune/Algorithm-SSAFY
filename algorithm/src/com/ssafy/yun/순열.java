package com.ssafy.yun;

import java.util.Arrays;
import java.util.Scanner;

public class 순열 {
	static int[] arr;
	static int[] sel;
	static int n, r;
	static boolean[] visited;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = 4;
		r = 2;
		arr = new int[] { 1, 2, 3, 4, 5, 6 };
		sel = new int[r];
		visited = new boolean[n];
		// 반복문
		print("반복문 이용한 순열 - 2개 뽑기");
		perm1();
		// 반복+재귀
		print("방문체크를 이용한 순열 ");
		perm2(0);
		// 재귀
		print("방문체크를 비트마스킹 순열");
		perm3(0, 0);

	}

	private static void print(String str) {
		System.out.println("-------------------");
		System.out.println(str);
		System.out.println("-------------------");
	}

	private static void perm1() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				System.out.printf("%d, %d\n", arr[i], arr[j]);
			}
		}
	}

	private static void perm2(int sidx) {
		if (sidx == r) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			sel[sidx] = arr[i];
			visited[i] = true;
			perm2(sidx + 1);
			visited[i] = false;
		}
	}

	private static void perm3(int sidx, int visited) {
		if (sidx == r) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = 0; i < n; i++) {
			if ((visited & (1 << i)) > 0) {
				continue;
			}

			sel[sidx] = arr[i];
			perm3(sidx + 1, visited | (1 << i));
		}
	}

}
