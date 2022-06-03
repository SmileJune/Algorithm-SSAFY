package com.ssafy.an.day049;

import java.util.Scanner;

public class Day48BOJ1904공일타일 { // 1904 01타일
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int ans = 0;
		int t1 = 1, t2 = 2;
		if(N == 1) ans = 1;
		else if(N == 2) ans = 2;
		else for(int i = 2 ; i < N ; i++) {
			ans = (t1 + t2) % 15746;
			t1 = t2;
			t2 = ans;
		} // 피보나치 수열의 모양이 된다는 것을 손코딩으로 확인하고 시작하기
		System.out.println(ans);
		sc.close();
	}
}
