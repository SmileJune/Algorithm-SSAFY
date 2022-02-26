package com.ssafy.ehoi;

import java.util.Scanner;

public class Day19_BOJ_S4_1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int cnt = 0; // 소수 개수를 세어줄 변수 초기화
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			boolean prime = true; // 아닐 때만 false로 바꾸겠다

			if (N == 1) {
				prime = false;
			}
			
			// 숫자 2, 3은 여기 범위에 못들어가지만 true로 초기화 되어 있으므로 소수가 됨
			
			for (int i = 2; i * i <= N; i++) { // 4부터만 들어갈 수 있구나
				if (N % i == 0) { // 0이면 소수가 아니다
					prime = false;
					break;
				}
			}

			if(prime) cnt++; // 소수이면 세주기

		}
		System.out.println(cnt);

		sc.close();
	}
}
