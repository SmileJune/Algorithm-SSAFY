package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_15649 {

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

		perm(0, 0);
	}

	static void perm(int sidx, int visited) {
		if (sidx == m) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if ((visited & (1 << i)) > 0) {
				continue;
			}

			sel[sidx] = arr[i];
			perm(sidx + 1, visited | (1 << i));
		}
	}

}
