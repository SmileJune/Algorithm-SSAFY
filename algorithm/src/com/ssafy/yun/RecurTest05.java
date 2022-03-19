package com.ssafy.yun;

import java.util.Arrays;

public class RecurTest05 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(solve(arr, 0));
		System.out.println(solve(arr, 0, 0));
	}

	static int solve(int[] arr, int idx) {
		if (arr.length == idx) {
			return 0;
		}
		return arr[idx] + solve(arr, idx + 1);
	}

	static int solve(int[] arr, int idx, int sum) {
		if (arr.length == idx) {
			return sum;
		}
		return solve(arr, idx + 1, sum + arr[idx]);
	}
}
