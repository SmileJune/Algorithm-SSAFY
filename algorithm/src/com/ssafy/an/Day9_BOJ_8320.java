package com.ssafy.an;

import java.util.Scanner;

public class Day9_BOJ_8320 { // 8320
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 1; i <= N; i++) {// 입력값이 6이라면 1~6까지 가능
			for (int j = i; j <= N; j++) {
				if (i * j <= N)
					cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
