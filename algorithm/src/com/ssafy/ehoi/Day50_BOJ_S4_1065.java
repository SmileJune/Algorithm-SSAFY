package com.ssafy.ehoi;

import java.util.Scanner;

public class Day50_BOJ_S4_1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1 ~ 1000 자연수
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			// 등차수열이면
			if(isRight(i)) cnt++;
		}
		
		System.out.println(cnt);
		
		sc.close();
	}
	
	public static boolean isRight(int n) {
		// 등차일 거라고 해야겠네
		boolean flag = true;
		
		String tmp = n + "";
		
		// 아 한 자리수 일 경우를 생각 안했구나
		if(tmp.length() == 1) {
			return true;
		}
		
		
		// 등차를 하나 구해보자
		char c1 = tmp.charAt(0);
		char c2 = tmp.charAt(1);
		int d = (c1-'0') - (c2-'0');
		
		// 나머지 애들이 이 등차와 같은지 비교해보자
		for (int i = 1; i + 1 < tmp.length(); i++) {
			char ch = tmp.charAt(i);
			char ch2 = tmp.charAt(i+1);
			int cha = (ch-'0') - (ch2-'0');
			// 다르면 넌 등차 아니야
			if (cha != d) {
				flag = false;
				break; // 더 볼 필요도 없어 나가 
			} 
		}
		// 계속 같았다면 true인 상태로 나왔겠지?
		return flag;
	}
}
