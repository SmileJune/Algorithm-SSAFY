package com.ssafy.an.day049;

import java.util.Scanner;

public class Day09BOJ8320직사각형 { // 8320
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
