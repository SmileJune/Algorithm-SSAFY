package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2661_좋은수열 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		backtracking("");
	}

	public static void backtracking(String str) {

		for (int i = 1; i <= 3; i++) {
			if (isGood(str)) {
				if (str.length() == N) {
					System.out.println(str);
					System.exit(0);
				}
				backtracking(str + i);
			}
		}
	}

	public static boolean isGood(String str) {
		int val = str.length() / 2;
		for (int i = 1; i <= val; i++) {
			if (str.isEmpty())
				return true;
			String frontStr = str.substring(str.length() - i - i, str.length() - i);
			String behindStr = str.substring(str.length() - i);
			if (frontStr.equals(behindStr))
				return false;

		}
		return true;
	}

}