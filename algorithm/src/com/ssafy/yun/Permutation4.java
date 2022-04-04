package com.ssafy.yun;

import java.util.Arrays;

public class Permutation4 {
	static int[] arr, sel;
	static int n;

	public static void main(String[] args) {
		n = 6;
		arr = new int[] { 1, 2, 3, 4, 5, 6 };
		sel = new int[n];
		perm(0, 0);
	}

	static void perm(int idx, int visited) {
		if (n == idx) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = 0; i < n; i++) {
			if ((visited & (1 << i)) > 0) {
				continue;
			}
			sel[idx] = arr[i];
			perm(idx + 1, visited | (1 << i));
		}

	}
}
