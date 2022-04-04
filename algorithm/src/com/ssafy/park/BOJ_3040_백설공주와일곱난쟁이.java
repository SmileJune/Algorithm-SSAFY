package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040_백설공주와일곱난쟁이 {
	static int[] arr;
	static int[] ans;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		ans = new int[7];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		check(0,0);
		System.out.println(sb);
	}
	public static void check(int num, int start) {
		if (num == 7 ) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += ans[i];
			}
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					sb.append(ans[i] + "\n");
				}
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			ans[num] = arr[i];
			check(num + 1, i + 1);
		}
	}
}
