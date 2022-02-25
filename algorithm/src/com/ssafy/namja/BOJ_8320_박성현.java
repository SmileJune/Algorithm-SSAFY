package com.ssafy.namja;


import java.util.Scanner;

public class BOJ_8320_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			int box = 0;
			for (int j = 0; j < i; j++) {
				box += i;
				if (box <= n)
					cnt++;
				else break;
			}
		}
		System.out.println(cnt);
	}
}