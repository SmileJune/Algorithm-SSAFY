package com.ssafy.ehoi;

import java.util.Scanner;

public class Day39_BOJ_S4_1065_Re {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1 ~ 1000 자연수
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			// 일단 두자리수면 걍 등차수열이야
			if (i < 100) {
				cnt++;
			} else { // 1000보다 작으니까 세자리수야 
				// 일의 자리수 - 십의 자리수 = 십의 자리수 - 백의 자리수
				if ((i%10)-((i/10)%10)==((i/10)%10)-((i/100))) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
		sc.close();
	}
		
}
