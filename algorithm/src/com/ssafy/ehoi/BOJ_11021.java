package com.ssafy.ehoi;

import java.util.Scanner;

public class BOJ_11021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 T 입력받기
		int T = sc.nextInt();
		
		// T만큼 반복하면서 
		for (int i = 1; i <= T; i++) {
			// 정수를 입력받아서 더하기!
			int a = sc.nextInt();
			int b = sc.nextInt();
			int sum = a+b;
			// Case #1: 1 + 1 = 2
			System.out.printf("Case #%d: %d + %d = %d\n", i, a, b, sum);
			
		}
		
		sc.close();
	}
}
