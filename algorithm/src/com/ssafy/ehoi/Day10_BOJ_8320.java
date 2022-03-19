package com.ssafy.ehoi;

import java.util.Scanner;

public class Day10_BOJ_8320 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 구할 것은 만들수 있는 직사각형의 갯수 (정수)
		int cnt = 1; // 정사각형 1개면 어차피 1
		
		// 입력 받을 것은 정사각형의 개수
		int n = sc.nextInt();
		
		// i는 가로, j는 세로
		for(int i = 2; i <=n; i++) {
			// 세로는 가로의 길이와 같을때까지만 직사각형을 만들 수 있음 (중복 방지)
			for (int j = 1; j <=i; j++) {
				if (i*j <= n) cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
		sc.close();
	}
}
