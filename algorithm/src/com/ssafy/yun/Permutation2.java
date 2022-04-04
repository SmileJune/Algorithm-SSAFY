package com.ssafy.yun;

import java.util.Arrays;

public class Permutation2 {
	static int[] arr;
	static int n;

	public static void main(String[] args) {
		n = 6;
		arr = new int[] { 1, 2, 3, 4, 5, 6 };
		perm(0);
	}

	static void perm(int k) {
		if (n == k) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		for (int i = k; i < n; i++) {
			swap(k, i);
			perm(k + 1);
			swap(k, i);
		}
	}

	static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		
	}
}
