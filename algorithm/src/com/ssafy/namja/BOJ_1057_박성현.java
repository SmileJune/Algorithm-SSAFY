package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_1057_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();	// 라운드수
		int A = sc.nextInt();	// 김지민
		int B = sc.nextInt();	// 임한수
		
		int cnt = 1;
		while (true) {
			if ((A == B - 1 || B == A - 1) && (A + 1) / 2 == (B + 1) / 2)
				break;
			A = (A + 1) / 2;
			B = (B + 1) / 2;
			cnt++;
		}
		System.out.println(cnt);
		
	}
}