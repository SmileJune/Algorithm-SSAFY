package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_2312_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int i = 2;
			int cnt = 0;
			while (true) {
				if (N % i == 0) {
					N /= i;
					cnt++;
				}
				else {
					if (cnt != 0)
						System.out.printf("%d %d\n", i, cnt);
					i++;
					cnt = 0;
					if (N == 1)
						break;
				}				
			}
		}
	}
}