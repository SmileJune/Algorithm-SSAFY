package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_3040 {

	static Scanner sc = new Scanner(System.in);
	static int[] arr, sel;

	public static void main(String[] args) {
		arr = new int[9];
		sel = new int[7];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		try {
			comb(0, 0);
		} catch (RuntimeException e) {
			for (int i = 0; i < sel.length; i++) {
				System.out.println(sel[i]);
			}
		}
	}

	static void comb(int idx, int sidx) throws RuntimeException {
		if (sidx == sel.length) {
			if (sumArr(sel) == 100) {
				throw new RuntimeException();
			}
		} else {
			for (int i = idx; i <= arr.length - sel.length + sidx; i++) {
				sel[sidx] = arr[i];
				comb(i + 1, sidx + 1);
			}
		}
	}

	static int sumArr(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

}
