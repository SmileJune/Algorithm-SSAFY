package com.ssafy.yun;

import java.util.Arrays;

public class Combination1 {

	static int[] arr, sel;

	public static void main(String[] args) {
		int n = 5;
		int r = 3;
		arr = new int[] { 1, 2, 3, 4, 5 };
		sel = new int[r];
		comb(n, r);

	}

	static void comb(int n, int r) {
		if (r == 0) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		if (n < r) {
			return;
		}

		sel[r - 1] = arr[n - 1];
		comb(n - 1, r - 1);
		comb(n - 1, r);
	}

}
