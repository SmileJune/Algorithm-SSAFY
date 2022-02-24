package com.ssafy.yun;

import java.util.Scanner;

public class SWEA_2007 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	static int solution() {
		String str = sc.next();
		int answer = 1;
		outer: for (int i = 1; i <= 10; i++) {
			for (int j = 0; j < i; j++) {
				if (str.charAt(j) != str.charAt(j + i)) {
					continue outer;
				}
			}
			answer = i;
			break;
		}

		return answer;
	}
}
