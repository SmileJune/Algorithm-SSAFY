package com.ssafy.yun;

import java.util.Scanner;

public class SWEA_1289 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	static int solution() {
		String str = sc.next();
		int flag = 0;
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (flag != str.charAt(i) - '0') {
				flag = (flag + 1) % 2;
				cnt++;
			}
		}

		return cnt;
	}

}
