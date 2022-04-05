package com.ssafy.yun;

import java.util.Arrays;
import java.util.Scanner;

public class 조합 {
	static int[] arr;
	static int[] sel;
	static int n, r;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		n = 6;
		r = 3;
		arr = new int[] { 1, 2, 3, 4, 5, 6 };
		sel = new int[r];
		// 반복문
		print("반복문");
		comb1();
		// 반복+재귀
		print("반복+재귀");
		comb2(0, 0);
		// 재귀
		print("재귀");
		comb3(0, 0);

	}

	private static void print(String str) {
		System.out.println("-------------------");
		System.out.println(str);
		System.out.println("-------------------");
	}

	private static void comb1() {
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					System.out.println(arr[i] + ", " + arr[j] + ", " + arr[k]);
				}
			}
		}
	}

	private static void comb2(int idx, int sidx) {
		if (sidx == r) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = idx; i < n; i++) {
			sel[sidx] = arr[i];
			comb2(i + 1, sidx + 1);
		}
	}

	private static void comb3(int idx, int sidx) {
		if (sidx == r) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		if (idx >= n) {
			return;
		}

		sel[sidx] = arr[idx];
		comb3(idx + 1, sidx + 1);
		comb3(idx + 1, sidx);
	}

}
