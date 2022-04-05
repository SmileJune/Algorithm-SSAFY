package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_15650 {

	static Scanner sc = new Scanner(System.in);
	static int[] arr, sel;
	static int n, m;

	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		sel = new int[m];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}

		comb(0, 0);
	}

	static void comb(int idx, int sidx) {
		if (sidx == m) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = idx; i < n; i++) {
			sel[sidx] = arr[i];
			comb(i + 1, sidx + 1);
		}
	}

}
