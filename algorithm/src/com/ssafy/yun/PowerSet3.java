package com.ssafy.yun;

import java.util.Arrays;

public class PowerSet3 {

	static int[] arr;
	static boolean[] visited;
	static int n;

	public static void main(String[] args) {
		n = 6;
		arr = new int[] { 1, 2, 3, 4, 5, 6 };
		visited = new boolean[n];

		powerSet(0);
	}

	static void powerSet(int k) {
		if (n == k) {
			for (int i = 0; i < arr.length; i++) {
				if (visited[i]) {
					System.out.print(arr[i]);
				}
			}
			System.out.println();
			return;
		}

		visited[k] = true;
		powerSet(k + 1);
		visited[k] = false;
		powerSet(k + 1);
	}
}
