package com.ssafy.yun;

import java.util.Arrays;

public class Combination4 {

	static int[] arr, sel;
	static int n, r;

	public static void main(String[] args) {
		n = 5;
		r = 3;
		arr = new int[] { 1, 2, 3, 4, 5 };
		sel = new int[r];

		comb(0, 0);
	}

	static void comb(int idx, int sidx) {
		if (sidx == r) {
			System.out.println(Arrays.toString(sel));
		}

		for (int i = idx; i <= n - r + sidx; i++) {
			sel[sidx] = arr[i];
			comb(i + 1, sidx + 1);
		}
	}

}
