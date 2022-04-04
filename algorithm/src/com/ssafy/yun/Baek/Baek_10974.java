package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_10974 {

	static Scanner sc = new Scanner(System.in);
	static int[] arr, sel;
	static int N;

	public static void main(String[] args) {
		N = sc.nextInt();
		arr = new int[N];
		sel = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		perm(0, 0);

	}

	static void perm(int idx, int visited) {
		if (N == idx) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) > 0) {
				continue;
			}

			sel[idx] = arr[i];
			perm(idx + 1, visited | (1 << i));
		}
	}

}
