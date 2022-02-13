package com.ssafy.ehoi;

import java.util.Scanner;

public class BOJ_1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 정수 받기
		int N = sc.nextInt();
		// N을 비교할 대상에 담아주기
		int c = N;
		int count = 0;
		
		while (true) {
			int a = c / 10;
			int b = c % 10;
			c = (b*10)+(a+b)%10;
			count++;
		
			if(c == N) break;
		}
		System.out.println(count);
		
		
		
		
		sc.close();
	}
}
